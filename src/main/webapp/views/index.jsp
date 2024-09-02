<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>


 
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  </head>
  <body>
     <div class="container">
        <h1 class="pb-3 pt-3">Report Application</h1>
        <form:form action="search" modelAttribute="search" method="POST">
             <table>
                 <tr>
                    <td>Plan Name :</td>
                    <td> 
                       <form:select path="planName">
                          <form:option value="">-Select-</form:option>
                          <form:options items="${plans}"/>
                      
                       </form:select> 
                    </td>
                    <td>Plan Status :</td>
                    <td> 
                       <form:select path="planStatus">
                          <form:option value="">-Select-</form:option>
                          <form:options items="${status}"/>
                       </form:select> 
                    </td>
                    <td>Gender :</td>
                    <td> 
                       <form:select path="gender">
                          <form:option value="">-Select-</form:option>
                          <form:options items="${gender}"/>
                       </form:select> 
                    </td>
                 </tr>
                 <tr>
                    <td>Start Date :</td>
                    <td>
                       <form:input type="Date" path="startDate" class="datepicker" data-date-format="mm/dd/yyyy"/>
                    </td>
                    
                    <td>End Date :</td>
                    <td>
                       <form:input type="Date" path="endDate" class="datepicker" data-date-format="mm/dd/yyyy"/>
                    </td>
                 
                 </tr>
                 <tr>
                     <td>
                       <a href="/" class="btn btn-secondary">reset</a>
                     </td>
                     <td>
                       <input type="submit" value="Search" class="btn btn-primary">
                     </td>
                 </tr>
             </table>         
        </form:form>
        <hr/>
         <table class="table table-striped table-hover">
           <thead>
             <tr>
               <td>Sl No.</td>
               <td>Holder Name</td>
               <td>Plan Name</td>
               <td>Plan Status</td>
               <td>Gender</td>
               <td>Start Date</td>
               <td>End Date</td>
             </tr>
           </thead>
           <tbody>
            <c:forEach items="${getPlans}" var="getPlan" varStatus="index">
               <tr>
                 <td>${index.count}</td>
                 <td>${getPlan.name}</td>
                 <td>${getPlan.planName}</td>
                 <td>${getPlan.planStatus}</td>
                 <td>${getPlan.gender}</td>
                 <td>${getPlan.startDate}</td>
                 <td>${getPlan.endDate}</td>
               </tr>
            </c:forEach>
            <tr>
              <c:if test="${empty getPlans}">
               <td colspan="8" style="text-align: center;">record not found</td> 
              </c:if>
            </tr>  
           </tbody>
         </table>
          
    
        <hr/>
        Export : <a href="excel">Excel</a>
 <a href="pdf">Pdf</a>
        
        
         
    
    
    
    
    
    
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  </body>
</html>