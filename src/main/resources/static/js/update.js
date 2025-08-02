// File: js/update.js

const apiUrl = "http://localhost:8085/api/book";

async function updateBook() {
  const id = document.getElementById("id").value;
  const title = document.getElementById("title").value;
  const author = document.getElementById("author").value;
  const category = document.getElementById("category").value;
  const available = document.getElementById("available").value;

  if (!id || !title || !author || !category || !available) {
    alert("Please fill in all fields.");
    return;
  }

  const book = { title, author, category, available };

  try {
    const res = await fetch(`${apiUrl}/${id}`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(book),
    });

    if (res.ok) {
      alert("Book Updated Successfully!");
    } else {
      alert("Failed to update the book.");
    }
  } catch (error) {
    console.error("Error updating book:", error);
    alert("Error occurred while updating book.");
  }
}




/*const apiUrl="http://localhost:8085/api/book";

async function updateBook(){
	const id=document.getElementById("id").value;
	const title=document.getElementById("title").value;
	const author=document.getElementById("author").value;
	const category=document.getElementById("category").value;
	const available=document.getElementById("available").value;

	const book={title,author,category,available};
	
	const res=await fetch(`${apiUrl}/${id}`,{
		method:"PUT",
		headers:{"Content-Type":"application/json"},
		body:JSON.stringify(book),
	});
	console.log(res)
	console.log(book)	
	if(res.ok){
		alert("Book Updated Successfully...");
		
	}else{
		alert("Failed to update Book...");
	}
	
}*/