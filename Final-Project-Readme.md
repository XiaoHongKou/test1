# Project Summary

#### Overview
This project is an integrated library borrowing management system designed to provide students, teachers, and library administrators with an efficient and intuitive platform for borrowing and managing books. The core components of the project include five main entities: Students, Teachers, Books, Libraries, and Loan Records.

#### Functionalities and Relationships
- **Many-to-Many Relationships**:
  - **Students and Teachers**: A many-to-many relationship is established between students and teachers, indicating that students can be guided by multiple teachers, and a teacher can guide multiple students.
  - **Books and Students**: There is also a many-to-many relationship between books and students, meaning students can borrow multiple books, and a book can be borrowed by multiple students.

- **One-to-One Relationship**:
  - **Books and Libraries**: Each book is associated with a specific library, forming a one-to-one relationship.

- **Loan Records**: This is a key entity that records the details of book borrowing, including the student who borrows the book, the teacher responsible, and the borrowed book.

#### Implementation Details
- **Data Model**: A well-designed data model handles complex many-to-many and one-to-one relationships, ensuring data consistency and integrity.
- **User Interface**: Provides an intuitive user interface for students and teachers to manage borrowing information easily, and powerful management tools for library administrators.
- **Security and Permissions**: The system implements role-based access control to ensure data security and appropriate user access levels.

#### Key Features
- **Book Management**: Allows library administrators to add, modify, and delete book information.
- **Loan Record Management**: Provides functionalities for creating, querying, and managing loan records, facilitating the tracking of book borrowing status.
- **Interaction between Students and Teachers**: Enables students and teachers to communicate on the platform, enhancing the learning and teaching experience.
- **Reporting and Analysis**: Generates reports on borrowing activities, assisting administrators in data analysis and decision-making.

#### Project Goals
Ultimately, this project aims to provide a comprehensive solution to meet the needs of borrowing and managing books in educational institutions, improving efficiency and user experience. By implementing the aforementioned functionalities and relationships, the system offers a reliable and user-friendly platform for students, teachers, and library administrators.

# Design

#### Functional Design
The library management system incorporates several key functionalities:
- **Student and Teacher Management**: Facilitates the creation, modification, and deletion of student and teacher profiles, including managing their many-to-many relationships.
- **Book and Library Management**: Enables adding, updating, and removing books, each linked to a specific library in a one-to-one relationship.
- **Loan Record Tracking**: Records and manages the lending of books, capturing details about the student, teacher, and book involved in each transaction.

#### Navigation Flow
The system's navigation is designed to be intuitive:
- **From Home Page**: Users can navigate to different sections such as Student Management, Teacher Management, Book Catalog, and Loan Records.
- **Within Each Section**: Users can perform relevant actions like adding new entries, editing existing ones, or viewing detailed information.
- **Admin Features**: Administrators have additional capabilities to manage users and system settings.

#### Extra Features and Insights
- **Advanced Search**: Implemented an advanced search feature for books and loan records to quickly filter and find specific entries.
- **Reporting Tools**: Integrated reporting tools for administrators to generate summaries and detailed reports about lending activities.

# Requirements

#### Installation and Running Guide
1. **Prerequisites**: Ensure Java 11 and Maven are installed on your system.
2. **Clone/Download the Project**: Get the project files from the repository.
3. **Build the Project**:
   - Navigate to the project directory.
   - Run `mvn clean install` to build the project.
4. **Deploy**:
   - Deploy the generated WAR file in `target` directory to a compatible Jakarta EE server like Payara or WildFly.

#### Tools and Libraries Versions
- Java Version: 11
- Jakarta EE API: 10.0.0
- MySQL Connector: 8.1.0
- EclipseLink JPA: 4.0.2
- Hibernate Validator: 8.0.1.Final
- JUnit Jupiter: 5.10.0
- Maven Compiler: 3.8.1
- Maven WAR Plugin: 2.3

# Include enough screen captures to illustrate your working project.
#### login page
  <img width="1800" alt="截屏2023-12-09 07 28 02" src="https://github.com/itmd4515/itmd4515-f23-fp-XiaoHongKou/assets/98803650/9b8a46e3-61f3-47bf-ba3e-0a434984db20">

#### register page
  <img width="1800" alt="截屏2023-12-09 07 28 09" src="https://github.com/itmd4515/itmd4515-f23-fp-XiaoHongKou/assets/98803650/4f3f7b5e-2218-4685-8879-43db61eb296e">
  <img width="1800" alt="截屏2023-12-09 07 39 51" src="https://github.com/itmd4515/itmd4515-f23-fp-XiaoHongKou/assets/98803650/65647584-c1cf-4d11-af54-2417f163d14e">

#### admin page
  <img width="1800" alt="截屏2023-12-09 07 28 26" src="https://github.com/itmd4515/itmd4515-f23-fp-XiaoHongKou/assets/98803650/bf3ec21b-442d-4cd7-86a7-0cd79e95c929">

#### teacher1 page
  <img width="1800" alt="截屏2023-12-09 07 28 26" src="https://github.com/itmd4515/itmd4515-f23-fp-XiaoHongKou/assets/98803650/483089bc-79ef-41d9-b528-b30394c30ffc">

#### schedule a LoanRecord
  <img width="1800" alt="截屏2023-12-09 07 28 51" src="https://github.com/itmd4515/itmd4515-f23-fp-XiaoHongKou/assets/98803650/a483a63a-d36b-44c0-ba1d-698b6bb8a0ce">

#### book1 page readonly
  <img width="1800" alt="截屏2023-12-09 07 29 40" src="https://github.com/itmd4515/itmd4515-f23-fp-XiaoHongKou/assets/98803650/961e0359-2e7c-4eef-8e20-308f59116e28">

# Expected Results/Known Issues

#### Known Issues
- **Intermittent Delays**: Occasional delays in updating loan records due to database locking issues.
- **User Interface**: Some pages might not render perfectly on older browsers.

#### Test Script
1. **Login as Admin**:
   - Username: `admin`
   - Password: `adminPass`
2. **Add a New Book**:
   - Navigate to Book Management.
   - Fill in the details and save.
3. **Create a Loan Record**:
   - Select a book and student.
   - Complete the loan process.
4. **View Reports**:
   - Go to the Reports section and generate a lending summary.

# Development Insights

#### Development Experience
Throughout the development of this library management system, my journey has been both challenging and rewarding. Tackling the complexities of relationships between entities like students, teachers, and books has deepened my understanding of database design and object-relational mapping. I particularly enjoyed the process of conceptualizing how these entities interact within the context of a library system and then translating these ideas into a functional application.

#### Learning Outcomes
One of the key learnings from this project was mastering many-to-many and one-to-one relationships in JPA. Navigating these relationships and ensuring the integrity of the database was a significant challenge. Additionally, I gained valuable experience in creating intuitive user interfaces that cater to different user roles, enhancing the user experience. Implementing role-based access control was another important aspect that taught me a lot about application security.

#### Areas for Further Exploration
Moving forward, I am keen to explore more advanced features like AI-driven book recommendations based on user preferences and borrowing history. Integrating machine learning to analyze borrowing patterns and optimize book acquisition and inventory management is another area that intrigues me. I also see great potential in enhancing the system with a mobile application to provide users with more flexible access.

#### Likes and Dislikes
I particularly enjoyed designing the user interface and the satisfaction of seeing a functional system come to life from a set of requirements. However, debugging and resolving issues related to entity relationships were sometimes frustrating. Balancing functionality and simplicity in the user interface was also a challenging aspect of this project.

In summary, this project was an invaluable learning experience that not only enhanced my technical skills but also improved my problem-solving abilities and understanding of user-centric application design.
