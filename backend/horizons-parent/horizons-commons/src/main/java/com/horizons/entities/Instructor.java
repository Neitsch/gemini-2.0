/**
 * Copyright 2015 Nigel Schuster.
 */


package com.horizons.entities;

import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author nschuste
 * @version 1.0.0
 * @since Sep 21, 2015
 */
@Entity
@Data
public class Instructor {
  @ManyToMany(mappedBy = "instructors", cascade = {javax.persistence.CascadeType.ALL})
  private Collection<CourseInstance> instances = new HashSet<>();
  @Column
  private String name;
  @Id
  @Column(columnDefinition = "BINARY(16)")
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  private UUID uuid;
}
