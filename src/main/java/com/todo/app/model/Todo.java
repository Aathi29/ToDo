package com.todo.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Todo")
public class Todo {
    @Id
    private String id;
    public String title;
    public String description;
    public String status;
    @CreatedDate
    public Date createdAt;
    @LastModifiedDate
    public  Date updatedAt;
}
