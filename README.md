# Software-Company-Management-System

Actiuni:
  - add-employee-in-team (name email salary position teamID programmingLanguages)
  - add-project (name deadline description teamID)
  - add-task (description priority projectID)
  - add-team (department name)
  - show-employees (department)
  - show-teams (department)
  - show-projects (teamID)
  - show-tasks (projectID)
  - delete-employee (employeeID)
  - delete-team (teamid)
  - finish-project (projectID)
  - finish-task (taskID)
  - salary-department (department)
  - salary-team (teamID)
  - add-employee-to-task (employeeID taskID)
  - update-team-name (teamID newName)
  - update-employee-name (employeeID newName)
  - update-project-team (projectID newTeamID)

Obiecte:
  - Employee
    - Developer
    - Tester
    - HumanResources
  - Team
  - Project
  - Department
    - HR
    - Marketing
    - IT
  - Task
  - GlobalService
