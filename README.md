# Miltrain App
*App for home & travel trainings for very busy hardworking people*

---

## v0.1.0
- **[FEATURE]** Add push-ups-service
- **[FEATURE]** Add abstract class Exercise
- **[FEATURE]** Add class User
---

## v0.2.0
- **[FEATURE]** Add class TrainingService
- **[FEATURE]** Add CRUD logic inside TrainingService
---

## v0.3.0
- **[FEATURE]** Add SpringBoot
- **[FEATURE]** Add class UserService
- **[FEATURE]** Add AppUtils for ID generation (UUID)
- **[FEATURE]** Implement createUser & getUsers REST methods
---

## v0.4.0
- **[FEATURE]** Implement REST methods: updateUserById & deleteUserById
- **[REFACTOR]** Code refactor
---

## v0.5.0
- **[REFACTOR]** Refactor TrainingService
- **[REFACTOR]** Refactor CRUD logic inside TrainingService
- **[REFACTOR]** Remove old Main class
- **[FEATURE]** Add TrainingNotFoundException
- **[FEATURE]** Add TrainingMaxSetLimitException
---

## v0.6.0
- **[CHANGE]** Switch userId from UUID to Long
- **[FEATURE]** Add and implement GlobalExceptionHandler for exceptions
- **[REFACTOR]** Refactor code TrainingService
- **[REFACTOR]** Refactor code UserService
- **[FEATURE]** Add return entities for TrainingService
---

## v0.7.0
- **[FEATURE]** Add UserNotFoundException
- **[FEATURE]** Add handleUserNotFound in GlobalExceptionHandler
- **[CHANGE]** Switch all errors from String to JSON
---

## v0.7.1
- **[FIX]** Bugfix DeleteResponse for User
- **[FIX]** Bugfix DeleteResponse for Training
---

## v0.7.2
- **[FIX]** Bugfix for getUserById
- **[FIX]** Bugfix for getTrainingById
- **[DOCS]** Make README be markdown
---

## **v1.0.0 — First Stable Release 🚀**
- **[FEATURE]** All core features implemented
- **[FEATURE]** REST CRUD methods for User & Training fully working
- **[FEATURE]** Exception handling in place
- **[REFACTOR]** Code refactored and cleaned
---

## v1.1.0
- **[FEATURE]** Add Postgres DB
- **[FEATURE]** Add application.yaml (local)
- **[DOCS]** Update gitignore
- **[CHANGE]** Remove "Map" as DB & Add Postgres DB
- **[CHANGE]** Switch logic in UserService from "MAP" & "List" to DB
- **[FIX]** BugFix with return in updateUserMethod
- **[FIX]** BugFix with delete User
---

## v1.2.0
- **[FEATURE]** Implement TrainingService in DB
- **[FEATURE]** Create new entity TrainingSet
- **[FEATURE]** Adjust TrainingSet to Training
---

## v1.2.1
- **[FIX]** Resolve problem with recursion in getTraining response
- **[FIX]** Remove setId from Json response in getTraining
---

# **v2.0.0 — Architecture & Persistence Stabilization**
- **[ARCHITECTURE]** Full transition to JPA/Hibernate with relational model
- **[ARCHITECTURE]** Introduced Training ↔ TrainingSet domain relationship
- **[FEATURE]** Enum-based exercise type persisted via JPA
- **[FIX]** Resolved bidirectional entity serialization issues (Jackson)
---

## v2.1.0
- **[FEATURE]** Implement Swagger Open Api docs
- **[FEATURE]** Implement AuthService with authorization POST http method
- **[FEATURE]** Implement AuthService with authentification POST http method
- **[FEATURE]** Implement RegisterRequestDTO, UserResponseDTO class
- **[FEATURE]** Add new LoginAlreadyExistsException
- **[FEATURE]** Add method existsByLogin(String login) in UserRepository
- **[FEATURE]** Implement Builder pattern for UserResponseDTO
- **[REFACTOR]** Remove createUser method from UserService & POST /users in UserController
---

## v2.2.1
- **[SECURITY]** Implement @Preauthorize in TrainingService
- **[SECURITY]** Add @EnableMethodSecurity to SecurityConfig
- **[FEATURE]** Tie User & Training entities through Adding DTO and Security Refactoring
- **[REFACTOR]** Add userLogin in JwtUtil
- **[REFACTOR]** Remove useless methods in Auth flow

# **v3.0.0 — JWT Authentication & Security Baseline**

## 🔐 Security & Authentication
- **[FEATURE]** JWT-based authentication (stateless)
- **[FEATURE]** Login & registration with token issuance
- **[SECURITY]** Endpoint protection via Spring Security filter chain
- **[SECURITY]** JWT request validation using `JwtAuthenticationFilter`
- **[SECURITY]** Role-based access control with `@PreAuthorize`
- **[SECURITY]** Stateless session policy (no HTTP sessions)

## v3.0.1
- **[FIX]** Allow public access to Swagger UI endpoints
- **[SECURITY]** Whitelist Swagger paths in Spring Security configuration

## v3.0.2
- **[SECURITY]** {SF-06} - JWT Security Hardening

## v3.1.0
- **[FEATURE]** {SF-07} Added interfaces with implementations


## v3.1.1
- **[SECURITY]** {SF-08} Implement role-based access control for Training methods (@PreAuthorize)