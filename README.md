# MMF abiturient
final task
## Used technologies

   * Back-end: Java 8, Servlet, WebFilter, WebListener, JSP, JSTL, Custom Tags.
   * Database: JDBC, MySQL, self-written connection-pool, transactions processing using ACID principles.
   * Front-end: HTML5, CSS3, JavaScript, responsive and adaptive web design for devices with small screens without front-end frameworks.
   * Tests: JUnit4.
   * Other: Tomcat, Maven, Log4j, Git.

## Application architecture:

   * Client - Server application architecture.
   * Layered architecture where main backend layers are: Single FrontEnd Controller with Commands <-> Service Layer <-> DAO Layer <-> MySQL RDBMS.

## Used design patterns:

  *  MVC.
  *  Factory.
  *  Controller.
  *  Command.
  *  DAO.
  *  Wrapper.
  *  Lazy initialization.
  *  Chain of responsibility.
  *  Other.

## Application features
### Common

  *  User role control.
  *  Custom user navigation prevention.
  *  Multi-language user interface (Russian and English languages).
  *  Frontend and backend validation of input parameters.

### Admin

  *  Login/logout.
  *  Add/edit/delete abiturients.
  *  Registrate new users.
  *  Change user role.

### User

  *  Login/logout.
  *  Add/edit/delete abiturients.

