package jgroup.StudentManager.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jgroup.StudentManager.model.Teacher;
import jgroup.StudentManager.repository.UserRepository;

@Service

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired

    private UserRepository userRepository;

    @Override

    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {

        Teacher teacher = userRepository.findByIdEquals(id);

        if (teacher == null) {

            throw new UsernameNotFoundException("このidのユーザを特定できません: " + id);

        }

        return new org.springframework.security.core.userdetails.User(

            teacher.getId(),

            teacher.getPassword(),

            Collections.emptyList()

        );

    }

    public boolean authenticate(String id, String password) {

        Teacher teacher = userRepository.findByIdEquals(id);

        if (teacher != null && teacher.getPassword().equals(password)) {

            return true; // パスワードが一致した場合は認証成功

        }

        return false; // IDが見つからないか、パスワードが一致しない場合は認証失敗

    }

	public Teacher getTeacherByUserid(String userid) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	public Teacher getTeacherByName(String userid) {
		// TODO 自動生成されたメソッド・スタブ
		return userRepository.getByName(userid);
	}

}