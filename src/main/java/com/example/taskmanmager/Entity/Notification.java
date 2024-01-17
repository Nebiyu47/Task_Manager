package com.example.taskmanmager.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "notificationId")
  private Long notificationId;
  @Column(name="content")
  private String content;
  @ManyToOne
  @JoinColumn(name = "recipient_id")
  private  User recipient;
}
