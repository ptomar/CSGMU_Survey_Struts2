
$(document).ready(function() {
    $("input[name='zip']").blur(function() //event handler assigned to zip 
	{
		Autofill($("input[name='zip']").val());
    });
	
	$("a#wrong_user_link").click(function() {  //event handler for wrong user link
	wrongPerson();
    });
			
});

$(function() {
$( document ).tooltip();
});

/*function Check() 
{  
var input;
var sum=0;
var avg;
var x=2;
var maxval;
var inputData = document.getElementById("dat").value; 
input = inputData.split(",");
var len=input.length;
if (len<10)
{ 
	$("#dialog").text("Please enter atleast ten comma seperated numbers");
	 $("#dialog").dialog();	
//alert("Please enter ten comma separated numbers ");
document.getElementById("dat").focus();
x=0;
}		

}*/


//Function to autofill city and state
function Autofill(zip) {
	$("input[name='city']").html("");
	$("input[name='state']").html("");	
	$("div#zerr").hide();
	var validzip = false;
	
    var xmlhttp;

   // code for IE7+, Firefox, Chrome, Opera, Safari
   try {
	xmlhttp = new XMLHttpRequest();
    } catch (e) {
	alert('Ajax error');
    }
	
    var url = "CityState.json";
		
    xmlhttp.onreadystatechange = function() {
	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
	    var x = JSON.parse(xmlhttp.responseText);
	    for (var i = 0; i < x.zipcodes.length; i++)
		if (x.zipcodes[i].zip == zip && zip.length==5) {
			validzip = true;
			var a = x.zipcodes[i].city;
			var b = x.zipcodes[i].state;
		    $("input[name='city']").val(a);
		    $("input[name='state']").val(b);
			
		    break;
		}
	    if (!validzip) {
			var a = "";
			var b = "";
			$("div#zerr").html("Please enter valid zip");
			$("div#zerr").show();
			$("input[name='city']").val(a);
		    $("input[name='state']").val(b);
		}
	}
    }
    xmlhttp.open("GET", "CityState.json", true);
	xmlhttp.overrideMimeType("application/json");
    xmlhttp.send(null);

}

//function to reset form
function resetform(){
	$("div#zerr").hide();
	$("div#DataError").hide();
	$("div#divError").hide();
	
	document.getElementById("surveyform").reset();
	
	
}

//Function to greet user
function Greeting(){
 var now = new Date(); // current date and time
 var hour = now.getHours(); // current hour (0-23)
 var name;
 var msg;
 if ( hour < 12 ) // determine whether it is morning
 msg="Good Morning, " ;
 else
 {
 hour = hour - 12; // convert from 24-hour clock to PM time

 // determine whether it is afternoon or evening
 if ( hour < 6 )
 msg="Good Afternoon, " ;
 else
 msg="Good Evening, " ;
 } // end else

 // determine whether there is a cookie
 if (document.cookie )
 {
 // convert escape characters in the cookie string to their
 // English notation
	var myCookie = unescape( document.cookie );

 // split the cookie into tokens using = as delimiter
	var cookieTokens = myCookie.split( "=" );

 // set name to the part of the cookie that follows the = sign
	name = cookieTokens[ 1 ];
 } // end if
 else
 {
 // if there was no cookie, ask the user to input a name
name = prompt( "Please enter your name:");
// escape special characters in the name string
 // and add name to the cookie
	document.cookie = "name=" + escape( name );
 } // end else

 document.getElementById("msg").innerHTML = msg+ name + ", Welcome to Assignment#3!";
 // document.write("<a href = 'javascript:wrongPerson()'> " +
//"Click here if you are not " + name + "</a>");
}

 // reset the document's cookie if wrong person
 function wrongPerson()
 {
 // reset the cookie
	document.cookie= "name=null;" +
" expires=Thu, 01-Jan-95 00:00:01 GMT";


 // reload the page to get a new name after removing the cookie
	location.reload();
 } // end function wrongPerson


/*//Function for max and avg 
 function Check(){
	$("div#DataError").show();
    //var a=0;
	//var b=0;
	//var nums=new Array(10);
	var x=document.getElementById("dat").value;
	var y=x.split(",");
	//var errormsg=new Array();
	var regex = /^[0-9,\b]+$/;
	
	for(i=0;i<y.length;i++)
	{
		if(!regex.test(y[i])){document.getElementById("DataError").innerHTML = "Invalid Input....Please enter numbers only."; 
		//document.getElementById("max").value="";
		//document.getElementById("avg").value="";
		return false;}
	}
	if (y.length<10)
	{
		errormsg.push("Error: Less than 10 numbers entered. Please enter atleast 10 numbers between 1 to 100 separated using commas."); 
		//document.getElementById("max").value="";
		//document.getElementById("avg").value="";
		
		
 }}*/
		
	/*for(i=0;i<y.length;i++)
	{
		nums[i]= parseFloat(y[i]);
	}
	
	for(i=0;i<y.length;i++)
	{
		if (nums[i]>100 || nums[i]<1) 
		{
			errormsg.push("Error: Please enter numbers between 1 and 100 only.");
			document.getElementById("max").value="";
			document.getElementById("avg").value="";
			
								
		}
	}	
	
var messageHtml = "";

if (!errormsg.length==''){
	
	var msg = "Error(s) on page:";
    
    errormsg.forEach(function (message) {
        messageHtml += "<li>" + message + "</li>";
    });
    
    document.getElementById("DataError").innerHTML = msg + messageHtml;
	return false;
}
			
	
for(i=0;i<y.length;i++)	
{
					
	a=a+nums[i];
	
}
				
for(i=0;i<y.length;i++)
{
	if (nums[i]>b)
	{
		b=nums[i];
	}
	
}	
	$("div#DataError").hide();
	var av=a/y.length;
	document.getElementById("avg").value=av;
	document.getElementById("max").value=b;
}*/


//Function to validate form

function ValidateForm() {
//Please note that email is checked by setting it input type as e-mail in html file
var name = document.getElementById("name").value;
var address = document.getElementById("address").value;
var checkboxes = document.getElementsByName("camp");
var radios = document.getElementsByName("university");
var email = document.getElementById("email").value;
var check=0;
var rcheck=0;
var namereg = /^[a-zA-Z ]*$/;
var addreg = /^(?=.*\d)[a-zA-Z\s\d\/]+$/;
var emailreg = /^[A-Za-z0-9](([_\.\-]?[a-zA-Z0-9]+)*)@([A-Za-z0-9]+)(([\.\-]?[a-zA-Z0-9]+)*)\.([A-Za-z]{2,})$/;
var numreg = /^[0-9]+$/;
var errormsg=new Array();


for (i=0;i<checkboxes.length && check<2;i++) //verifying atleast 2 checkboxes are checked
{
	if(checkboxes[i].checked){check=check+1;}
	
}


for (i=0;i<radios.length && rcheck<2;i++)  //verifying atleast one radio button is selected
{
	if(radios[i].checked){rcheck=rcheck+1;}
	
}


if(!namereg.test(name) || name=='') //check if name have alphabets only
{
	errormsg.push("Invalid Name.\n");
	document.getElementById('name').value='';
	document.getElementById('name').style.borderColor="red";
	
} else{document.getElementById('name').style.borderColor="";}

if(!emailreg.test(email) || email=='')
{
	errormsg.push("Invalid Email.\n");
	document.getElementById('email').value='';
	document.getElementById('email').style.borderColor="red";
	
} else{document.getElementById('email').style.borderColor="";}

if(!addreg.test(address) && !namereg.test(address) && !numreg.test(address) || address=='')
{
	errormsg.push("Invalid Address.\n");
	document.getElementById('address').value='';
   document.getElementById('address').style.borderColor="red";
	
} else{document.getElementById('address').style.borderColor="";}

if(namereg.test(name) && name!='')  
{
	if(emailreg.test(email) && email!='')
    {
		if(address=='' || addreg.test(address) && namereg.test(address) && numreg.test(address))
		{
			surveyform.address.focus();
		}
		else
		{
			//return true;
			//surveyform.zip.focus();
		}	
	}
	else
	{
		surveyform.email.focus();
	}
}   
else
{
	surveyform.name.focus();
} 
	


if(check<2) 
{
	errormsg.push("Check atleast 2 checkboxes.\n");	
  //document.getElementById('camp').style.borderColor="red";
	
} //else{document.getElementById('camp').style.borderColor="";}

if(rcheck<1)  
{
	errormsg.push("Select one radio button.\n");
	//document.getElementById('university').style.borderColor="red";
	
} //else{document.getElementById('university').style.borderColor="";}



var x=document.getElementById("dat").value;
	var y=x.split(",");
	//var errormsg=new Array();
	var regex = /^[0-9,\b]+$/;
	
	for(i=0;i<y.length;i++)
	{
		if(!regex.test(y[i])){errormsg.push( "Only numbers allowed in Data field."); 
		//document.getElementById("max").value="";
		//document.getElementById("avg").value="";
		document.getElementById('dat').style.borderColor="red";
	
} else{document.getElementById('dat').style.borderColor="";}
		}
	
	if (y.length<10)
	{
		errormsg.push("Enter atleast 10 numbers in data field"); 
		//document.getElementById("max").value="";
		//document.getElementById("avg").value="";
		document.getElementById('dat').style.borderColor="red";
	
} else{document.getElementById('dat').style.borderColor="";}
		
		
 



//display error messages if any
var messageHtml = "";

if (errormsg.length==''){return true;}

else{
	
	var msg = "Error(s) on page:";
    
    errormsg.forEach(function (message) {
        messageHtml += "<li>" + message + "</li>";
    });
    $("#divError").dialog({
	    modal : true,
	    buttons : {
		Ok : function() {
		    $(this).dialog("close");
		}
	    }
	});
	$("#divError p").show();
    }
    document.getElementById("divError").innerHTML = msg + messageHtml;
	return false;
	
};