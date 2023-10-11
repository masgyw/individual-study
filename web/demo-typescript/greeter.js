function greeter(person) {
    return "hello ," + person.firstName + "-" + person.lastName;
}
var user = { firstName: "san", lastName: "zhang" };
document.body.innerHTML = greeter(user);
