/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonView;
import com.horizons.jsonview.AllCoursesView;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 21, 2015
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Instructor implements Serializable {
  @ManyToMany(mappedBy = "instructors", cascade = {javax.persistence.CascadeType.ALL})
  private Collection<Course> instances = new HashSet<>();
  @Column(unique = true)
  @JsonView(AllCoursesView.class)
  private String name;
  @Id
  @Column(columnDefinition = "BINARY(16)")
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  private UUID uuid;
}
