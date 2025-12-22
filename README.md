# Miltrain App
*App for home & travel trainings for very busy hardworking people*
---
---

---

## v0.1.0
- Add push-ups-service
- Add abstract class Exercise
- Add class User
---

## v0.2.0
- Add class TrainingService
- Add CRUD logic inside TrainingService
---

## v0.3.0
- Add SpringBoot
- Add class UserService
- Add AppUtils for ID generation (UUID)
- Implement createUser & getUsers REST methods
---

## v0.4.0
- Implement REST methods: updateUserById & deleteUserById
- Code refactor
---

## v0.5.0
- Refactor TrainingService
- Refactor CRUD logic inside TrainingService
- Remove old Main class
- Add TrainingNotFoundException
- Add TrainingMaxSetLimitException
---

## v0.6.0
- Switch userId from UUID to Long
- Add and implement GlobalExceptionHandler for exceptions
- Refactor code TrainingService
- Refactor code UserService
- Add return entities for TrainingService
---

## v0.7.0
- Add UserNotFoundException
- Add handleUserNotFound in GlobalExceptionHandler
- Switch all errors from String to JSON
---

## v0.7.1
- Bugfix DeleteResponse for User
- Bugfix DeleteResponse for Training
---

## v0.7.2
- Bugfix for getUserById
- Bugfix for getTrainingById
- Make README be markdown
---



## **v1.0.0 — First Stable Release 🚀**
- All core features implemented
- REST CRUD methods for User & Training fully working
- Exception handling in place
- Code refactored and cleaned
---


## v1.1.0
- Add Postgres DB
- Add application.yaml (local)
- Update gitignore
- Remove "Map" as DB & Add Postgres DB
- Switch logic in UserService from "MAP" & "List" to DB
- BugFix with return in updateUserMethod
- BugFix with delete User
---


## v1.2.0
- **[FEATURE]** Implement TrainingService in DB 
- **[FEATURE]** Create new entity TrainingSet 
- **[FEATURE]** Adjust TrainingSet to Training 

## v1.2.1
- **[FIX]** - Resolve problem with recursion in getTraining
response
- **[FIX]** - Remove setId from Json response in getTraining