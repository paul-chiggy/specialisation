package sandbox;

/**
 * Created by root on 17-2-17.
 */
public class Person {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Person(String name, int age, String nationality)
    {
        this.age = age;
        this.name = name;
        this.nationality = nationality;
        introduce();
    }

    public Person() {}

    private String name = null;
    private Integer age = null;
    private String nationality = null;

    private void introduce()
    {
        System.out.println("Hi! My name is " + name + ". I'm " + age + " years old and I am " + nationality);
    }
}
