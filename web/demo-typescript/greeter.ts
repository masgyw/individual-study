interface Person {
  firstName:string;
  lastName:string;
}

function greeter(person:Person) {
  return "hello ," + person.firstName + "-" + person.lastName;
}

let user = {firstName: "san", lastName: "zhang"};

document.body.innerHTML = greeter(user);