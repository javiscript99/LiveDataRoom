package com.example.javi.room_livedata_viewmodel;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity (tableName = "class_table")
public class ClassEntity {

    @PrimaryKey
    @NonNull
    public String classid;
    @ColumnInfo(name = "Tutor")
    public String tutor;
    @ColumnInfo(name = "Delegate")
    public String delegate;
    @ColumnInfo(name = "Profesor")
    public String profesor;
    @ColumnInfo(name = "Course")
    public String course;
    @ColumnInfo(name = "Student")
    public String students;



    public ClassEntity(@NonNull String id, String tutor, String delegate, String profesor, String course, String students) {
        this.classid = id;
        this.course= course;
        this.profesor = profesor;
        this.students = students;
        this.tutor = tutor;
        this.delegate = delegate;

    }

    @NonNull
    public String getClassid() {
        return classid;
    }

    public void setClassid(@NonNull String classid) {
        this.classid = classid;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getDelegate() {
        return delegate;
    }

    public void setDelegate(String delegate) {
        this.delegate = delegate;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getStudents() {
        return students;
    }

    public void setStudents(String students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "ClassEntity{" +
                "classid='" + classid + '\'' +
                ", tutor='" + tutor + '\'' +
                ", delegate='" + delegate + '\'' +
                ", profesor='" + profesor + '\'' +
                ", course='" + course + '\'' +
                ", students='" + students + '\'' +
                '}';
    }
}