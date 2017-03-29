# Database Table DDL scripts
1. user_details:


CREATE TABLE `user_details` (
	`user_id`	BIGINT NOT NULL,
	`first_name`	VARCHAR(100) NOT NULL,
	`last_name`	VARCHAR(100),
	`email`	VARCHAR(150) NOT NULL UNIQUE,
	`phone`	INT,
	FOREIGN KEY(`user_id`) REFERENCES user_authentication(id) ON DELETE CASCADE ON UPDATE CASCADE
);
2. user_authentication: 

CREATE TABLE `user_authentication` (
	`id`	BIGINT NOT NULL UNIQUE,
	`user_name`	VARCHAR(100) NOT NULL UNIQUE,
	`password`	VARCHAR(100) NOT NULL UNIQUE,
	PRIMARY KEY(`id`)
);

3. job_details
CREATE TABLE `job_details` (
	`id`	BIGINT NOT NULL UNIQUE,
    `user_id` BIGINT NOT NULL,
	`job_name`	VARCHAR(100) NOT NULL UNIQUE,
	`job_description`	VARCHAR(150),
    `job_command` varchar(150) NOT NULL,
	`job_status` VARCHAR(50)
	PRIMARY KEY(`id`),
    foreign key(`user_id`) REFERENCES user_authentication(id) ON DELETE CASCADE ON UPDATE CASCADE


);



# cron job overview
Cron is driven by a crontab (cron table) file, a configuration file that specifies shell commands to run periodically on a given schedule. The crontab files are stored where the lists of jobs and other instructions to the cron daemon are kept. Users can have their own individual crontab files and often there is a system-wide crontab file (usually in /etc or a subdirectory of /etc) that only system administrators can edit.

Each line of a crontab file represents a job, and looks like this:

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