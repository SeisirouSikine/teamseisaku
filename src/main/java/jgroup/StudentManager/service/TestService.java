package jgroup.StudentManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import jgroup.StudentManager.model.Student;
import jgroup.StudentManager.model.Test;
import jgroup.StudentManager.repository.StudentRepository;
import jgroup.StudentManager.repository.TestRepository;
 

@Service
@Transactional
public class  TestService{

    @Autowired
    private TestRepository testrepository;
    
    @Autowired
    private StudentRepository studentrepository;
    
    

    /**
     * 学生一覧の取得
     * @return List<Gakusei>
     */
    public List<Test> getTestList() {
        List<Test> entityList = this.testrepository.findAll();
        return entityList;
    }

    /**
     * 詳細データの取得
     * @param @NonNull Long index

     */
    public Test get(@NonNull Long index) {
    	Test test = this.testrepository.findById(index).orElse(new Test());
        return test;
    }


    public void save(@NonNull Test test) {
        this.testrepository.save(test);
    }

    /**
     * アドレス帳データの削除
     * @param @NonNull Long index
     */
    public void delete(@NonNull Long index) {
        this.testrepository.deleteById(index);
    }
    
	public List<Test> filterPoints(String point) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	public List<Student> Test(Integer entyear, String classnum) {
		return studentrepository.findByEntyearAndClassnum(entyear,classnum);
	}

	



	public List<Test> getAllStudentsBySchoolcd(String schoolcd) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}


    
}