//fetching all the buttons ,it will be array of nodes
var tabButtons = document.querySelectorAll(".tabContainer .buttonContainer button");
//storing all the panels	
var tabPanels = document.querySelectorAll(".tabContainer .tabPanel");

function showPanel(panelIndex, colorCode) {
	tabButtons.forEach(function(node) {
		node.style.background = "";
		node.style.color = "";

	});
	tabButtons[panelIndex].style.backgroundColor = colorCode;
	tabButtons[panelIndex].style.color = "white";

	tabPanels.forEach(function(node) {
		node.style.display = "none";
	});
	tabPanels[panelIndex].style.display = "block";
	tabPanels[panelIndex].style.backgroundColor = colorCode;

}
showPanel(0,'gray');

var max_fields = 4;
var addbtn = document.getElementById("addbtn");

function AddField() {
	if (x == 5) {
		addbtn.remove();
	}

	var fields = ["Secondary", "Higher-Secondary", "Graduation", "Post-Graduation"];
	if (x < 4) {
		x++;

		var educationTable = document.getElementById("EducationTable");
		var tr = document.createElement("tr");
		var td = document.createElement("td");
		var td2 = document.createElement("td");
		var td3 = document.createElement("td");
		var td4 = document.createElement("td");
		var td5 = document.createElement("td");

		//	var form = document.createElement("form");
		//	form.setAttribute("method", "post");
		//	form.setAttribute("action", "EducationServlet");


		var fieldName = document.createElement("select");
		fieldName.setAttribute("name", "FieldName");
		for (var val of fields) {
			var option = document.createElement("option");
			option.value = val;
			option.text = val.charAt(0).toUpperCase() + val.slice(1);
			fieldName.appendChild(option);
		}



		var nameOfSchool = document.createElement("input");
		nameOfSchool.setAttribute("type", "text");
		nameOfSchool.setAttribute("name", "NameofSchool");

		var nameOfBoard = document.createElement("input");
		nameOfBoard.setAttribute("type", "text");
		nameOfBoard.setAttribute("name", "NameofUniversity");

		var grade = document.createElement("input");
		grade.setAttribute("type", "text");
		grade.setAttribute("name", "Grade");

		// Create a submit button
		var saveButton = document.createElement("input");
		saveButton.setAttribute("type", "submit");
		saveButton.setAttribute("value", "Save");

		//	educationTable.appendChild(form);
		educationTable.appendChild(tr);
		tr.appendChild(td);
		tr.appendChild(td2);
		tr.appendChild(td3);
		tr.appendChild(td4);
		tr.appendChild(td5);

		td.appendChild(fieldName);
		td2.appendChild(nameOfSchool);
		td3.appendChild(nameOfBoard);
		td4.appendChild(grade);
		td5.appendChild(saveButton);

		if (x == 4) {
			addbtn.remove();
		}
	}
	else {
		addbtn.remove();
	}
}

function enableAll() {

	document.getElementById("firstname").disabled = false;
	document.getElementById("lastname").disabled = false;
	document.getElementById("designation").disabled = false;
	document.getElementById("email").disabled = false;
	document.getElementById("houseno").disabled = false;
	document.getElementById("streetname").disabled = false;
	document.getElementById("locality").disabled = false;
	document.getElementById("city").disabled = false;
	document.getElementById("state").disabled = false;
	document.getElementById("pincode").disabled = false;
	document.getElementById("country").disabled = false;
}

var divinfo = document.getElementById("divinfo");
var update1 = document.createElement("input");
update1.type = "submit";
update1.value = "Update";
update1.setAttribute("onclick", "enableAll()");


function Editfirstname() {
	document.getElementById("firstname").disabled = false;
	update1.remove();
	divinfo.appendChild(update1);
	var btn2 = document.getElementById("fneditbtn");
	btn2.remove();
}
function Editlastname() {
	document.getElementById("lastname").disabled = false;
	update1.remove();
	divinfo.appendChild(update1);
	var btn4 = document.getElementById("lneditbtn");
	btn4.remove();
}
function Editdesignation() {
	document.getElementById("designation").disabled = false;
	update1.remove();
	divinfo.appendChild(update1);
	var btn6 = document.getElementById("designbtn");
	btn6.remove();
}
function Editemail() {
	document.getElementById("email").disabled = false;
	update1.remove();
	divinfo.appendChild(update1);
	var btn8 = document.getElementById("emailbtn");
	btn8.remove();
}

var divAdd = document.getElementById("divAdd");
var update2 = document.createElement("input");
update2.type = "submit";
update2.value = "Update";
update2.setAttribute("onclick", "enableAll()");

function EditHouseno() {
	document.getElementById("houseno").disabled = false;
	update2.remove();
	divAdd.appendChild(update2);
	var btn12 = document.getElementById("housebtn");
	btn12.remove();
}
function EditStreetname() {
	document.getElementById("streetname").disabled = false;
	update2.remove();
	divAdd.appendChild(update2);
	var btn14 = document.getElementById("streetbtn");
	btn14.remove();
}
function EditLocality() {
	document.getElementById("locality").disabled = false;
	update2.remove();
	divAdd.appendChild(update2);
	var btn16 = document.getElementById("localitybtn");
	btn16.remove();
}
function EditCity() {
	document.getElementById("city").disabled = false;
	update2.remove();
	divAdd.appendChild(update2);
	var btn18 = document.getElementById("citybtn");
	btn18.remove();
}
function EditState() {
	document.getElementById("state").disabled = false;
	update2.remove();
	divAdd.appendChild(update2);
	var btn20 = document.getElementById("statebtn");
	btn20.remove();
}
function EditPincode() {
	document.getElementById("pincode").disabled = false;
	update2.remove();
	divAdd.appendChild(update2);
	var btn22 = document.getElementById("pincodebtn");
	btn22.remove();
}
function EditCountry() {
	document.getElementById("country").disabled = false;
	update2.remove();
	divAdd.appendChild(update2);
	var btn24 = document.getElementById("countrybtn");
	btn24.remove();
}

//var divEdu = document.getElementById("divEdu");
var FormEdu = document.getElementById("formEdu");
var update = document.createElement("input");
update.type = "submit";
update.value = "Update";
function editEdu0() {
	document.getElementById("schoolId0").disabled = false;
	document.getElementById("boardId0").disabled = false;
	document.getElementById("gradeId0").disabled = false;
	var edit0 = document.getElementById("edit0");
	edit0.remove();
	addbtn.remove();
	update.remove();
	FormEdu.setAttribute("action","UpdateEducation1");
	FormEdu.appendChild(update);
}

function editEdu1() {
	document.getElementById("schoolId1").disabled = false;
	document.getElementById("boardId1").disabled = false;
	document.getElementById("gradeId1").disabled = false;
	var edit1 = document.getElementById("edit1");
	edit1.remove();
	addbtn.remove();
	update.remove();
	FormEdu.setAttribute("action","UpdateEducation");
	FormEdu.appendChild(update);
}
function editEdu2() {
	document.getElementById("schoolId2").disabled = false;
	document.getElementById("boardId2").disabled = false;
	document.getElementById("gradeId2").disabled = false;
	var edit2 = document.getElementById("edit2");
	edit2.remove();
	addbtn.remove();
	update.remove();
	FormEdu.setAttribute("action","UpdateEducation");
	FormEdu.appendChild(update);
}
function editEdu3() {
	document.getElementById("schoolId3").disabled = false;
	document.getElementById("boardId3").disabled = false;
	document.getElementById("gradeId3").disabled = false;
	var edit3 = document.getElementById("edit3");
	edit3.remove();
	addbtn.remove();
	update.remove();
	FormEdu.setAttribute("action","UpdateEducation");
	FormEdu.appendChild(update);
}








