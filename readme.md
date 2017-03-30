# Disclaimer
The project is not fully functionally working. UI also not functional. I tried my best to code the whole scenario but due lack of time its not finished. To be honest in my opinion this application may be have designed and coded far better way than this, if little more time can be invested into this.
I listed below the points

### What are not done

#### Backend
* User creation and saving to database has issue with hibernate automatic id generation. Its failing to create a user.(fixed)
* Similar to user "Job" is also have issue of saving.(fixed)
* "User" Testcase is not passing due to above issues (fixed)
* "Job" Testcases are also not passing due the same. Since not tested, coding is also written based on assumptions.(fixed)
* "UserService" not having proper validations for user creations and authentications.
* Password encryption methodology not added.
* Session variables not used for storing User releated data for single sign-on validation concept.
* "JobService" not having validation to job command.
* Job commands are not segregated for day month year and day of week functionality to check the validation

#### Database
* Job table is created with job command as flat String structure. Which need to be segregated for command and frequency of job
* In User table passowrd is not saved as encrypted.
* No specific access security added to access database through backend

#### UI
* Basic workflow is not working since backend controllers are not repsonding.
* Angular js codes tends fail due to poor coding design.
* Cross orgin issue persists due to UI is deployed in different server than backend.
* UI and backend are not consolidated in single Web server project.
* UI testng is not added.
* UI view for Job creation is not coded properly.


## Running the Application
- You need run the SpringBoot Runner class, ApplicationRunner.java under com.scheduler package

- or else run using maven spring-boot goal, [mvn spring-boot:run]

- To execute UI, You need a tomcat server or apache server and put the whole UI folder into webcontent folder.
 (Important: Since already port: 8080 is used , please change the UI server port, there is cross origin issue which required Spring boot   code changes. Adding [ @CrossOrigin(origins = "http://localhost:<port>")] on top of every Controller class.)
 
- You need to run the following Database scripts in MySql
 (Important: database name in application.properties is set to online_scheduler, please change accordingly if you have different name   and then use the below scripts before running the server)
 
### Database Table scripts
- (dont run the scripts since hibernate automatically creates the table)
```sql
1. user_details:
CREATE TABLE `user_details` (
	`id`	BIGINT NOT NULL,
	`first_name`	VARCHAR(100) NOT NULL,
	`last_name`	VARCHAR(100),
`user_name` VARCHAR(100) NOT NULL UNIQUE,
`password`  VARCHAR(100) NOT NULL,
	`email`	VARCHAR(150) NOT NULL UNIQUE,
	`phone`	INT, PRIMARY KEY(`id`)
	
);

INSERT INTO `online_scheduler`.`user_details`
(`first_name`,`last_name`,`email`,`phone`,`id`,`user_name`,`password`)VALUES("some","last","some@last",21234,2,"somelast","somelast");

2. job_details
CREATE TABLE `job_details` (
	`id`	BIGINT NOT NULL UNIQUE,
    `user_id` BIGINT NOT NULL,
	`job_name`	VARCHAR(100) NOT NULL UNIQUE,
	`job_description`	VARCHAR(150),
    `job_command` varchar(150) NOT NULL,
	`job_status` VARCHAR(50)
	PRIMARY KEY(`id`),
    foreign key(`user_id`) REFERENCES user_details(id) ON DELETE CASCADE ON UPDATE CASCADE
);

```

### cron job overview
Cron is driven by a crontab (cron table) file, a configuration file that specifies shell commands to run periodically on a given schedule. The crontab files are stored where the lists of jobs and other instructions to the cron daemon are kept. Users can have their own individual crontab files and often there is a system-wide crontab file (usually in /etc or a subdirectory of /etc) that only system administrators can edit.

Each line of a crontab file represents a job, and looks like this:
```bash
 ?????????????? minute (0 - 59)
 ? ?????????????? hour (0 - 23)
 ? ? ?????????????? day of month (1 - 31)
 ? ? ? ?????????????? month (1 - 12)
 ? ? ? ? ?????????????? day of week (0 - 6) (Sunday to Saturday;
 ? ? ? ? ?                                       7 is also Sunday)
 ? ? ? ? ?
 ? ? ? ? ?
 * * * * *  command to execute
The syntax of each line expects a cron expression made of five fields, followed by a shell command to execute.

While normally the job is executed when the time/date specification fields all match the current time and date, there is one exception: if both "day of month" (field 3) and "day of week" (field 5) are restricted (not "*"), then one or both must match the current day.[3]

For example, the following clears the Apache error log at one minute past midnight (00:01) every day, assuming that the default shell for the cron user is Bourne shell compliant:

1 0 * * *  printf > /var/log/apache/error_log
This example runs a shell program called export_dump.sh at 23:45 (11:45 PM) every Saturday.

45 23 * * 6 /home/oracle/scripts/export_dump.sh
```