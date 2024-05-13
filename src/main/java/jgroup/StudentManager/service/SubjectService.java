package jgroup.StudentManager.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import jakarta.annotation.Nonnull;
import jakarta.transaction.Transactional;
import jgroup.StudentManager.model.Student;
import jgroup.StudentManager.model.Subject;
import jgroup.StudentManager.repository.SubjectRepository;

 
@Service

@Transactional

public class SubjectService {

 
		@Autowired

		private SubjectRepository repository;
 
		/**

		 * アドレス帳一覧の取得

		 * @return List<oharabank>

		 */

		public List<Subject> getSubjectList() {

		    List<Subject> entityList = this.repository.findAll();

		    return entityList;

		}
 
		/**

		 * 詳細データの取得

		 * @param @NonNull Long index

		 * @return  AddressBook

		 */

		public Subject get(@NonNull Long index) {

			Subject subject = this.repository.findById(index).orElse(new Subject());

			return subject;

		}

		/**

		 * アドレス帳一覧の取得

		 * @param AddressBook addressBook

		 */

		public void save(@Nonnull Subject subject) {

			this.repository.save(subject);

			System.out.println(subject);

		}

		/**

		 * アドレス帳データの削除

		 * @param @NonNull Long index

		 */

		public void delete(@NonNull Long id) {

			this.repository.deleteById(id);

		}

		public Subject getOneBook(Long id) {

	        // idを指定して本の情報を取得する

	        Subject subject = this.repository.findById(id).orElseThrow();

	        // 画面返却用のFormに値を設定する

	        return subject;

	    }
 
	    // 本を更新する

	    public void update(Subject editSubject) {

	        // データベースに登録する値を保持するインスタンスの作成

	        System.out.println(editSubject);


	        // データベースを更新する

	        this.repository.save(editSubject);

	        System.out.println("aaa");

	    }

 
 
	    public Subject getSubject(Long id) {

	    	Subject subject = this.repository.findById(id).orElse(null);

	    	return subject;

	    	}

		public List<Student> filterStudents(Integer entyear, String classnum) {
			// TODO 自動生成されたメソッド・スタブ
			return null;
		}

		public List<Subject> getAllSubjectBySchoolcd(String schoolcd) {
			// TODO 自動生成されたメソッド・スタブ
			return null;
		}





	    }
 