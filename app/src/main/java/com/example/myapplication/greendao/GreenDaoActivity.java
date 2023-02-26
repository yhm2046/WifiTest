package com.example.myapplication.greendao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * dao的增删改查操作,2023.2.26 Sunday
 * reference:<a href="https://www.jianshu.com/p/aa4e172f7d47">...</a>
 */
public class GreenDaoActivity extends AppCompatActivity {
    private static final String TAG = "GreenDaoActivity:evan";
    DaoSession daoSession;
    UserDao userDao;
    List<User> result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        main();
    }//onCreate

    private void main() {
        try {
             daoSession = ((MyApplication) getApplication()).getDaoSession();
             userDao = MyApplication.getInstaces().getDaoSession().getUserDao();
//            insertData();
//            delete2();
            updateUser();
             result =  queryAll();
//            for (int i = 0; i < result.size(); i ++){
//                delete(result.get(i));
//            }
//            result = queryAll();
            if (result != null){
                for(int i = 0;i < result.size(); i++){
                    Log.i(TAG,"result" + i + ":"
                            + result.get(i).getId()
                            + "," + result.get(i).getAge()
                            + "," + result.get(i).getName());
                }
                Log.i(TAG,"find user counts is:" + result.size());
            }else{
                Log.i(TAG,"list is null");
            }
            Log.i(TAG,"main success!");
        } catch (Exception e) {
            Log.i(TAG,"main error:" + e);
            throw new RuntimeException(e);
        }
    } //main
//   增
public void insertData() {
    for (int i = 0; i < 10; i++) {
        User student = new User();
//        student.setId((long) i);  //id是自动生成的,唯一值
//        int age = 3 + new Random().nextInt(1000);
        int age = getOnlyInt() + i;
        student.setAge(age);
        student.setName("user" + i);
        daoSession.insert(student);
    }
}//insertData
//
    private int getOnlyInt(){
        Set<Integer> usedNumbers = new HashSet<Integer>();
        int randomNumber = 0;

        while(true){
            randomNumber = (int)(Math.random() * 100);
            if(!usedNumbers.contains(randomNumber)){
                usedNumbers.add(randomNumber);
                break;
            }
        }
        return randomNumber;
    }
////查
    public List<User> query(String str){
        return daoSession.queryRaw(User.class, " where age = ?", str);
    }

    public List<User> queryAll(){
        return daoSession.loadAll(User.class);
    }

//删
    public void delete(User s){
        daoSession.delete(s);
    }
    public void deleteAll(){
        daoSession.deleteAll(User.class);
    }

    /**
     * 从数据库中删除指定数据
     */
    public void delete2(){
        QueryBuilder qb=userDao.queryBuilder();
        // 查询想要删除的记录；根据场景需要，记得判空
        List<User> userList=qb.where(UserDao.Properties.Name.eq("user2")).list();
        for(User user:userList){
            // 每次删除一条记录
            userDao.delete(user);
        }
    }
//    改
private void updateUser(){
    User user=userDao.queryBuilder().where(UserDao.Properties.Name.eq("user1")).build().unique();
    // 修改使用setter方法
    user.setAge(99);
    userDao.update(user);
}//end update
}