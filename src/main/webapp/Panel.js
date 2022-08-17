 //fetching all the buttons ,it will be array of nodes
	var tabButtons = document.querySelectorAll(".tabContainer .buttonContainer button");
 //storing all the panels	
	var tabPanels = document.querySelectorAll(".tabContainer .tabPanel");

	function showPanel(panelIndex, colorCode) {
		tabButtons.forEach(function(node) {
			node.style.background="";
			node.style.color="";
			
		});
		tabButtons[panelIndex].style.backgroundColor = colorCode;
		tabButtons[panelIndex].style.color = "white";
		
		tabPanels.forEach(function(node) {
			node.style.display = "none";
		});
		tabPanels[panelIndex].style.display = "block";
		tabPanels[panelIndex].style.backgroundColor = colorCode;
		
	}
	 
           
            function AddField() {
			
			var fields=["Secondary","Higher-Secondary","Graduation","Post-Graduation"];
			
	
			
             var educationTable=document.getElementById("EducationTable");
			 var tr=document.createElement("tr");
			 var td=document.createElement("td");
			 var td2=document.createElement("td");
			 var td3=document.createElement("td");
		     var td4=document.createElement("td");
             var td5=document.createElement("td");

               	var form = document.createElement("form");
                form.setAttribute("method", "post");
                form.setAttribute("action", "EducationServlet");
				//form.appendChild();
			
                var fieldName = document.createElement("select");
				fieldName.setAttribute("name","FieldName");
				for (const val of fields){
				var option = document.createElement("option");
				option.value = val;
				option.text = val.charAt(0).toUpperCase()+ val.slice(1);
				fieldName.appendChild(option);
				}
				
				
          
                var nameOfSchool = document.createElement("input");
                nameOfSchool.setAttribute("type", "text");
                nameOfSchool.setAttribute("name", "NameofSchool");
			   // nameOfSchool.setAttribute("size","40px");
            
				var nameOfBoard = document.createElement("input");
                nameOfBoard.setAttribute("type", "text");
                nameOfBoard.setAttribute("name", "NameofUniversity");
			   // nameOfBoard.setAttribute("size","40px");
                 
                var grade = document.createElement("input");
                grade.setAttribute("type", "text");
                grade.setAttribute("name", "Grade");
              
                // Create a submit button
                var saveButton = document.createElement("input");
                saveButton.setAttribute("type", "submit");
                saveButton.setAttribute("value", "Save");
			
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
				
				
				}
		
       
       