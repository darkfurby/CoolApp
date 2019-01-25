<%@page import="model.User" %>
<%@page import="dao.ItemDao" %>
<%@page import="model.Item" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@page import="dao.ItemCartDao" %>
<%@page import="model.ItemCart" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%User user = (User) session.getAttribute("user"); %>
    <% ItemDao itemDao = new ItemDao(); %>
    <%List<Item> itemList = itemDao.ReadAll(); %>
    <%ItemCartDao itemCartDao = new ItemCartDao(); %>
    
   
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>Main content</title>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" >
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="index.jsp">Main Page</a>
    </div>
    <ul class="nav navbar-nav">
        <li><a href="login_page.jsp">Log in</a></li>
      <li><a href="register_page.jsp">Register new account</a></li>
      <li><a href="admin_page.jsp">Admin Panel</a></li>
      <li><a href="main_page.jsp">Content page, if you are logged in</a></li>
      <li><a href="about_me.jsp">About Me</a></li>
      <li><a href="https://github.com/darkfurby/CoolApp">My GIT repo</a></li> 
    </ul>
  </div>
</nav>

<div style="margin-top:100px" align="center"> ok main page will be here</div>

<div align=center>
<button type="button" class="btn btn-info btn-lg" data-toggle="collapse" data-target="#demo">Show available items to get</button>

<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Cart</button>

<!--  <a>heheszki </a> -->

<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Your shopping</h4>
      </div>
      <div class="modal-body">
        <%List<ItemCart> itemUserList = itemCartDao.showItemsOfUser(user.getUserID() ); %>
        
        
		<table class="table">
		<thead>
		 <tr>
        <th>Item ID</th>
        <th>Item Name</th>
        <th>Transaction ID</th>
      	</tr>
		</thead>
		<tbody>
		
		<% for(ItemCart i : itemUserList){ Item itemName = itemDao.readItem( Integer.toString(i.getItemId() ) ); %>
		<tr> 
			<td><%=i.getItemId()  %> <%System.out.println("item id: " + i.getItemId()); %> </td> 								
			<td><%=itemName.getItemName() %> <%System.out.println("item name: " + itemName.getItemName() ); %> </td> 
			<td><%=i.getTranId() %>  <%System.out.println("item trans id: "+ i.getTranId() ); %></td> 								
			
											
		</tr>
		 <%} %>
		</tbody>
		</table>
		 
  
        
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>


<br>

<div id="demo" class="collapse">
		<table class="table">
		<thead>
		 <tr>
        <th>Item name</th>
        <th>Item price</th>
        <th>Item type</th>
      	</tr>
		</thead>
		<tbody>
		
		<% for(Item i : itemList){ %>
		<tr> 
			<td><%=i.getItemName()  %>  </td> 
			<td><%=i.getItemPrice() %> </td> 
			<td><%= i.getItemType() %> </td>								
			<td>
				<form action="AddToCart" method="get"> <!--   target="formDestination" -->
				<button type="submit" name="addToCart" value="<%=i.getItemId() %>">Add to cart</button>
				</form>
		   </td>								
		</tr>
		 <%} %>
		</tbody>
		</table>
		 
  </div>

</div>
<div id="divCheckbox" style="visibility: hidden">
<iframe name="formDestination"></iframe>
</div>
</body>
</html>