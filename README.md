# Employee Management System

## Project Description

This Employee Management system program, built with JavaFX, allows users to add, view, calculate, and manage employee salaries for various types of employees. The system uses an abstract class `Employee` with subclasses `FullTimeEmployee`, `PartTimeEmployee`, and `Contractor`, each implementing unique salary calculations based on employee type.

### Features
- **Add Employees**: Input and add employees with different salary structures.
- **Calculate Salaries**: Automatically calculate and display salaries based on employee type.
- **Remove Employees**: Remove selected employees from the list.
- **View Employee List**: Display employee details in a table format, including name, type, and calculated salary.

## How to Run the Program

1. **Clone the Repository**:
   ```bash
   git clone <repository_url>
   ```

2. **Build and Run the Application**:
   - Use a Java IDE (IntelliJ)
   compile and run via JavaFX setup in your IDE).

## Application Usage

### Adding Employees
1. **Full-Time Employee**:
   - Enter name and select "Full-time" in the type dropdown.
   - Enter the annual salary in "Annual Salary" field.

2. **Part-Time Employee**:
   - Enter name, select "Part-time" in the type dropdown.
   - Enter hourly wage in "Hourly Wage" and hours worked in "Hours Worked".

3. **Contractor**:
   - Enter name, select "Contractor" in the type dropdown.
   - Enter hourly rate in "Hourly Wage" and max hours allowed in "Max Hours".

### Sample Inputs
- **Full-time Employee**:
  - **Name**: Alice
  - **Annual Salary**: 50000

- **Part-time Employee**:
  - **Name**: Bob
  - **Hourly Wage**: 20
  - **Hours Worked**: 80

- **Contractor**:
  - **Name**: Charlie
  - **Hourly Rate**: 30
  - **Max Hours**: 160

### Screenshots

#### Initial View
![Снимок экрана 2024-11-11 155512](https://github.com/user-attachments/assets/284fe469-a2b3-48d5-8f0a-1ac1c06d6f4f)

#### Full-time Employee Added
![Снимок экрана 2024-11-11 155040](https://github.com/user-attachments/assets/8de1587a-51cc-4f2f-8d08-956c8a129fdb)

#### Part-Time Employee Added
![Снимок экрана 2024-11-11 155229](https://github.com/user-attachments/assets/4ab72896-3815-44d7-9a69-1b8b3f568962)

#### Contractor Added
![Снимок экрана 2024-11-11 155404](https://github.com/user-attachments/assets/d83bfec3-cba1-4ba5-8868-35ad854d5c92)


--- 
