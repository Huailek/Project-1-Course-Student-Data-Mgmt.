public record Student (String id, String lastName, String firstName, String email, String phone) implements Comparable<Student> {
    public Student {
        if(id == null || id.isEmpty() ){
            throw new IllegalArgumentException("Can't be null or empty");
        }
        if(lastName == null || lastName.isEmpty() ){
            throw new IllegalArgumentException("Can't be null or empty");
        }
        if(firstName == null || firstName.isEmpty() ){
            throw new IllegalArgumentException("Can't be null or empty");
        }
        if(email == null || email.isEmpty() ){
            throw new IllegalArgumentException("Can't be null or empty");
        }
        if(phone == null || phone.isEmpty() ){
            throw new IllegalArgumentException("Can't be null or empty");
        }
    }
    public boolean equals(Student other) {
        if (other == null || !(other instanceof Student)) {
            return false;
        } else if (other == this) {
            return true;
        } else {
            Student otherStud = (Student) other;
            if (compareTo(otherStud) == 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public int compareTo(Student o) {
        return this.lastName.compareTo(o.lastName);
    }
}