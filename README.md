<!-- <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Music Library REST API</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            margin: 40px;
            background-color: #fafafa;
            color: #333;
        }
        h1, h2, h3 {
            color: #2c3e50;
        }
        h1 {
            border-bottom: 3px solid #2c3e50;
            padding-bottom: 10px;
        }
        h2 {
            margin-top: 40px;
            border-left: 6px solid #3498db;
            padding-left: 10px;
        }
        h3 {
            margin-top: 25px;
            color: #34495e;
        }
        p {
            margin: 10px 0;
        }
        ul {
            margin-left: 30px;
        }
        li {
            margin-bottom: 6px;
        }
        code {
            background-color: #eee;
            padding: 3px 6px;
            border-radius: 4px;
            font-size: 0.95em;
        }
        pre {
            background-color: #272822;
            color: #f8f8f2;
            padding: 15px;
            border-radius: 6px;
            overflow-x: auto;
        }
        .section {
            margin-bottom: 40px;
        }
        .note {
            background-color: #eaf2f8;
            padding: 15px;
            border-left: 5px solid #3498db;
            margin: 20px 0;
        }
    </style>
</head>
<body> -->

<h1>🎵 Music Library REST API</h1>

<div class="section">
    <h2>A. Project Overview</h2>
    <p>
        This project is a <strong>Music Library REST API</strong> developed using
        <strong>Spring Boot</strong>. The system allows users to manage
        <em>songs, podcasts, artists, albums, and playlists</em> using standard
        CRUD operations.
    </p>
    <p>
        The application follows <strong>OOP principles</strong>,
        <strong>SOLID design</strong>, and applies common
        <strong>design patterns</strong> used in real-world backend systems.
    </p>
</div>

<div class="section">
    <h2>B. REST API Documentation</h2>
    <h3>Available Endpoints</h3>
    <ul>
        <li><strong>Songs</strong>: <code>/songs</code></li>
        <li><strong>Podcasts</strong>: <code>/podcasts</code></li>
        <li><strong>Artists</strong>: <code>/artists</code></li>
        <li><strong>Albums</strong>: <code>/albums</code></li>
        <li><strong>Playlists</strong>: <code>/playlists</code></li>
    </ul>
    <h3>HTTP Methods</h3>
    <ul>
        <li><code>GET</code> – retrieve data</li>
        <li><code>POST</code> – create new entities</li>
        <li><code>PUT</code> – update existing entities</li>
        <li><code>DELETE</code> – remove entities</li>
    </ul>
    <h3>Sample JSON Request (Create Song)</h3>
    <pre>{
  "title": "Master of Puppets",
  "genre": "Metal",
  "artist": { "id": 1 },
  "album": { "id": 1 }
}</pre>
    <h3>Sample JSON Response</h3>
    <pre>{
  "id": 1,
  "title": "Master of Puppets",
  "genre": "Metal"
}</pre>
    <div class="note">
        📸 Postman screenshots demonstrate successful GET, POST, PUT, and DELETE requests.
    </div>
</div>

<div class="section">
    <h2>C. Design Patterns</h2>
    <h3>Singleton</h3>
    <p>
        Used by Spring-managed beans such as <code>@Service</code>,
        <code>@Repository</code>, and <code>@Controller</code>.
        Spring creates a single instance per bean by default.
    </p>
    <h3>Factory</h3>
    <p>
        The <strong>MediaFactory</strong> is responsible for creating
        <code>Song</code> and <code>Podcast</code> objects.
        This encapsulates object creation logic and improves scalability.
    </p>
    <h3>Builder (Conceptual)</h3>
    <p>
        Builder pattern is used conceptually for creating complex objects
        with multiple parameters, improving readability and reducing errors.
    </p>
</div>

<div class="section">
    <h2>D. Component Principles</h2>
    <ul>
        <li>Clear separation of concerns</li>
        <li>High cohesion within classes</li>
        <li>Loose coupling via Dependency Injection</li>
        <li>Reusable and testable components</li>
    </ul>
</div>

<div class="section">
    <h2>E. SOLID & OOP Summary</h2>
    <ul>
        <li><strong>Inheritance</strong>: Song and Podcast extend Media</li>
        <li><strong>Polymorphism</strong>: Media used as a common type</li>
        <li><strong>Encapsulation</strong>: Private fields with getters/setters</li>
        <li><strong>SRP</strong>: Each class has one responsibility</li>
        <li><strong>OCP</strong>: System is open for extension</li>
        <li><strong>LSP</strong>: Subclasses replace base class safely</li>
        <li><strong>DIP</strong>: Services depend on abstractions</li>
    </ul>
</div>

<div class="section">
    <h2>F. Database Schema</h2>
    <ul>
        <li><code>media</code></li>
        <li><code>song</code></li>
        <li><code>podcast</code></li>
        <li><code>artist</code></li>
        <li><code>album</code></li>
        <li><code>playlist</code></li>
        <li><code>playlist_media</code> (Many-to-Many join table)</li>
    </ul>
</div>

<div class="section">
    <h2>G. System Architecture Diagram</h2>
    <pre>
Client (Postman)
      ↓
REST Controllers
      ↓
Service Layer
      ↓
JPA Repositories
      ↓
Database
    </pre>
</div>

<div class="section">
    <h2>H. How to Run the Application</h2>
    <pre>
git clone https://github.com/your-repository/musiclibrary.git
cd musiclibrary
mvn clean spring-boot:run
    </pre>
    <p>
        Application runs at:
        <code>http://localhost:8080</code>
    </p>
</div>

<div class="section">
    <h2>I. Reflection</h2>
    <p>
        During this project, I gained practical experience with Spring Boot,
        REST API development, database relationships, and object-oriented design.
        I learned how SOLID principles and design patterns improve code quality,
        maintainability, and scalability in real backend systems.
    </p>
</div>

</body>
</html>
