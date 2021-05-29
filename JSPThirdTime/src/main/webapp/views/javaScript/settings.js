/**
 * 
 */
 
 	function validate() {
			var name = document.getElementById("username").value;
			if (name != "" && name.length > 0) 
				return true;
			else {
				alert("Please enter your username");
				return false;
			}
		}