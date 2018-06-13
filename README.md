# Mount Olive Robotics Team 2018 Off-Season
### Contributors: Joshua Ciffer, and yea no one else at this point... Thanks for the help.


# Agenda

### General
- Code could use lots of additional documentation.
- New constant values and port numbers need to be filled in.
- Clean up util package.
### Hardware
- Clean up IO class.
### Control
- Find out button mappings.
  - Which commands are triggered on what action (button release, held, pressed, etc).
### Auton
- Current autons (DriveDistance, TurnDegrees, etc) need to be tested.
- Once all subsystems are 100% functional and tested, we can start working on some advanced auton stuff.
### Drivetrain
- Drivetrain and shifting code is done just needs to be tested.
### Elevator
- Elevator commands and subsystem need to be worked on.
  - Reminder that elevator is now only one stage.
  - Elevator subsystem class needs to be reviewed.
  - MoveElevator command needs to be rewritten.
### Intake
- All intake subsystems and commands need to be tested THOROUGHLY.
  - Intake shifter may need to be modified depending on how the mechanical kids build the intake.
### Climber
- Entire climber subsystem needs to be written.
  - Climber consists of a piston that extends up and down.
  - What needs to be written:
    - Climber Subsystem
    - ExtendClimber command (actuates climber piston)
    - ClimberState hardware state enum

# Resources
- Project API: https://joshua-ciffer.github.io/MORT-2018-Off-Season/
- WPILib API: http://first.wpi.edu/FRC/roborio/release/docs/java/
- CTRE API: http://www.ctr-electronics.com/downloads/api/java/html/index.html
