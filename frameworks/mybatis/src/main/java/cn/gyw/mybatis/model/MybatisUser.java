package cn.gyw.mybatis.model;

public class MybatisUser {

    private String id;

    private String firstName;

    private Integer age;

    private MybatisRole role;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public MybatisRole getRole() {
		return role;
	}

	public void setRole(MybatisRole role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "MybatisUser [id=" + id + ", firstName=" + firstName + ", age=" + age + ", role=" + role + "]";
	}

}
