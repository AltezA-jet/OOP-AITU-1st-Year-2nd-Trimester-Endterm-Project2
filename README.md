# OOP-AITU-1st-Year-2nd-Trimester-Endterm-Project~~
A. Project Overview

This project is a Music Library REST API built with Spring Boot.
It allows users to manage songs, podcasts, and playlists using CRUD operations.

B. REST API Documentation
Example: Create Song

POST /songs

Request:

{
  "title": "Imagine",
  "artist": "John Lennon",
  "genre": "Rock"
}


Response:

{
  "id": 1,
  "title": "Imagine",
  "artist": "John Lennon",
  "genre": "Rock"
}

Example: Add Media to Playlist

POST /playlists/1/media/2

Response:

{
  "message": "Media added to playlist"
}


📸 Postman screenshots should show successful GET, POST, PUT, DELETE requests.

C. Design Patterns Section
Singleton

Used by Spring-managed beans (@Service, @Controller)

Factory

MediaFactory creates Song and Podcast objects

Builder

Used conceptually for creating complex objects cleanly

D. Component Principles Section

Clear separation of layers

Independent, reusable components

Loose coupling via dependency injection

E. SOLID & OOP Summary

Inheritance (Song, Podcast → Media)

Polymorphism via Media usage

Encapsulation through private fields

All SOLID principles applied

F. Database Schema

Tables:

media

playlist

playlist_media (join table)

G. System Architecture Diagram
Client (Postman)
      ↓
REST Controller
      ↓
Service Layer
      ↓
JPA Repository
      ↓
H2 / Database

H. How to Run the Application
git clone <repository-url>
cd musiclibrary
mvn clean
mvn spring-boot:run


Application will start at:

http://localhost:8080
