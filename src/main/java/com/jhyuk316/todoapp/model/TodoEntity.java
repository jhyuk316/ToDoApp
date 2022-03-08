package com.jhyuk316.todoapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Todo")
public class TodoEntity {
    @Id
    @GeneratedValue(generator = "system-uuid") // id 자동생성
    // system-uuid라는 이름의 제너레이터 정의하여 사용.
    @GenericGenerator(name = "system-uuid", strategy = "uuid") //
    private String id;
    private String userId;
    private String title;
    private boolean done;
}
