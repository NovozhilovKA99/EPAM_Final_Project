select  * from Cast 
where 
(User_idDriver = 7 or User_idConductor = 7) 
and 
((startTime between 2019-09-23 11:00:00 and 2019-09-23 13:00:00) or (endTime between  2019-09-23 12:00:00 and 2019-09-23 13:00:00))