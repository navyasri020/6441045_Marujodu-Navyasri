// Exercise 1
console.info("Welcome to the Community Portal");
window.addEventListener("load", () => alert("Page is fully loaded!"));

// Exercise 2
let eventDetails = {
  name: "Community Cleanup",
  date: "2025-06-15",
  seats: 50,
};
console.log(`${eventDetails.name} is scheduled for ${eventDetails.date}. Seats left: ${eventDetails.seats}`);
eventDetails.seats--;

// Exercise 3
const eventsArr = [
  { name: "Music Night", date: "2025-06-20", seats: 10 },
  { name: "Past Event", date: "2024-06-01", seats: 0 },
];
const currentDate = new Date();
eventsArr.forEach(({ name, date, seats }) => {
  const eventDate = new Date(date);
  console.log(eventDate > currentDate && seats > 0 ? `Upcoming Event: ${name}` : `Skipping: ${name}`);
});
try {
  let toRegister = eventsArr[0];
  if (toRegister.seats <= 0) throw new Error("No seats available!");
  toRegister.seats--;
  console.log("Registered successfully.");
} catch (e) {
  console.error("Registration failed:", e.message);
}

// Exercise 4
const addEventEntry = (name, category) => ({ name, category });
const register = (user, event) => console.log(`${user} registered for ${event.name}`);
const byCategory = (arr, category) => arr.filter(e => e.category === category);

const categoryCounter = () => {
  let count = 0;
  return () => ++count;
};
const trackMusicCategory = categoryCounter();
console.log(trackMusicCategory());
console.log(trackMusicCategory());

// Exercise 5
function EventItem(name, seats) {
  this.name = name;
  this.seats = seats;
}
EventItem.prototype.isAvailable = function () {
  return this.seats > 0;
};
const jazzEvent = new EventItem("Jazz Night", 20);
console.table(Object.entries(jazzEvent));
console.log(jazzEvent.isAvailable());

// Exercise 6
const activities = [
  { name: "Yoga", type: "health" },
  { name: "Rock Concert", type: "music" },
  { name: "Jazz", type: "music" },
];
const onlyMusic = activities.filter(({ type }) => type === "music");
const cardList = activities.map(({ name }) => `Event: ${name.toUpperCase()}`);
console.log(cardList);

// Exercise 7
const eventListEl = document.querySelector("#eventList");
const renderCard = ({ name, date }) => {
  const card = document.createElement("div");
  card.className = "eventCard";
  card.textContent = `${name} - ${date}`;
  eventListEl.appendChild(card);
};

// Exercise 8
document.querySelector("#registerBtn").addEventListener("click", () => alert("You registered!"));
document.querySelector("#categoryFilter").addEventListener("change", e => filterEvents(e.target.value));
document.querySelector("#searchInput").addEventListener("keydown", e => {
  if (e.key === "Enter") console.log("Searching for:", e.target.value);
});

// Exercise 9
fetch("https://mockapi.io/events")
  .then(r => r.json())
  .then(data => console.log("Events:", data))
  .catch(e => console.error(e));

async function getEvents() {
  document.querySelector("#loading").style.display = "block";
  try {
    const res = await fetch("https://mockapi.io/events");
    const json = await res.json();
    console.log(json);
  } catch (error) {
    console.error("Failed to load events", error);
  } finally {
    document.querySelector("#loading").style.display = "none";
  }
}

// Exercise 10
const eventSet = [{ name: "Yoga", date: "2025-07-01", category: "health" }];
const logDetails = ({ name, date }) => console.log(`${name} on ${date}`);
const copiedList = Array.from(eventSet);
logDetails(eventSet[0]);

// Exercise 11
document.querySelector("#regForm").addEventListener("submit", function (e) {
  e.preventDefault();
  const { name, email, event } = e.target.elements;
  if (!name.value || !email.value) {
    document.querySelector("#errorMsg").textContent = "All fields are required.";
    return;
  }
  console.log(`Registered ${name.value} for ${event.value}`);
});

// Exercise 12
const sendRegistrationData = data => {
  document.querySelector("#status").textContent = "Submitting...";
  setTimeout(() => {
    fetch("https://mockapi.io/register", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(data)
    })
      .then(res => res.json())
      .then(() => document.querySelector("#status").textContent = "Registered successfully!")
      .catch(() => document.querySelector("#status").textContent = "Failed to register.");
  }, 2000);
};

// Exercise 13
console.debug("Submitting form...");
try {
  const formData = { name: "John", email: "john@mail.com" };
  console.debug("Payload:", formData);
} catch (error) {
  console.error("Error:", error);
}

// Exercise 14
$("#registerBtn").on("click", function () {
  alert("You clicked register!");
  $(".eventCard").fadeOut().fadeIn();
});
