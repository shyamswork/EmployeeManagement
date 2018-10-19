# EmployeeManagement


Employee management using spring- boot java .

This is a sample REST API application built based on spring boot 2 using java programmming language . The application provides some of the End points like below :-

1)Create Employee record(s)

2) Update existing Employee record(s)

3) Delete an existing Employee record.

The web application has the embedded Tomcat server which can boot up in windows by executing following command on the command line

      Excecute this command to boot up the web applicaton server:-  java -jar company-employee-management-0.0.1-SNAPSHOT.jar.

Once the server started the below URLs can be tried out .

 
                      URL sample : POST : http://localhost:8080/create-employee
                      
Example body [ { "id" : "500", "fullName" : "updated", "age" : "25", "salary" : "30000" }, { "id" : "400", "fullName" : "updated", "age" : "30", "salary" : "100000" } ]

Note :- 'id' uniqueness has not handled and it can be handled by providing a UUID or timestamp+random number or sequence etc .

If employee Management information .json file exists then Create single Employee record or number of employee records as JSON array input to the json file.The new entries will be appended to the existing records at the last.                              

If the File not exist or file is empty File will be created and new records will be inserted .

                      URL sample : POST : http://localhost:8080/update-employee
                      
Example body [ { "id" : "500", "fullName" : "updated", "age" : "25", "salary" : "30000" }, { "id" : "400", "fullName" : "updated", "age" : "30", "salary" : "100000" } ]

Update existing Employee record(s) Return back the modified content of the .json file for debug or test

Input is the JSON Array which will have the Employees need to update , then First step will be delete all records which are already exising in .json file based on the Employee.id .                                                              
Then the List of Employees records will be inserted in to the file using this.createEmeployeeJSONObject() method which hence uses the same logic as create records



                      URL sample : DELETE : http://localhost:8080/delete-employee/300
                      
Delete an existing Employee record Return back the modified content of the .json file for debug or test
