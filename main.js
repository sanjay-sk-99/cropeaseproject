const equipmentData = [
  {
    category: "Harvest Machines",
    machines: [
      {
        name: "Rice Harvester",
        rate: 2000,
        image: "assets/hm-1.jpg",
        region: "Saravanampatti",
        link: "machine-details.html",
      },
      {
        name: "Multifunctional Harvester",
        rate: 2500,
        image: "assets/hm-2.jpg",
        region: "Saravanampatti",
        link: "machine-details.html",
      },
      {
        name: "Small Rice Combine Harvester",
        rate: 1800,
        image: "assets/hm-3.jpg",
        region: "Singanallur",
        link: "machine-details.html",
      },
      {
        name: "Soyabean Combine Harvester",
        rate: 2000,
        image: "assets/hm-4.jpeg",
        region: "Kanur",
        link: "machine-details.html",
      },
    ],
  },
  {
    category: "Tractors",
    machines: [
      {
        name: "Mahindra Yuvaraj Tractor",
        rate: 500,
        image: "assets/t-1.webp",
        region: "Saravanampatti",
        link: "machine-details.html",
      },
      {
        name: "Mahindra OJA",
        rate: 500,
        image: "assets/t-2.webp",
        region: "Singanallur",
        link: "machine-details.html",
      },
      {
        name: "Swaraj Tractor",
        rate: 800,
        image: "assets/t-3.jpg",
        region: "Kanur",
        link: "machine-details.html",
      },
      {
        name: "50hp John Deere Tractor",
        rate: 1000,
        image: "assets/t-4.webp",
        region: "Singanallur",
        link: "machine-details.html",
      },
    ],
  },
  {
    category: "Fertilizers & Pesticides",
    machines: [
      {
        name: "Battery Spraying Machine",
        rate: 300,
        image: "assets/f-1.webp",
        region: "Singanallur",
        link: "machine-details.html",
      },
      {
        name: "Pressure Spray Pump",
        rate: 400,
        image: "assets/f-2.webp",
        region: "Kanur",
        link: "machine-details.html",
      },
      {
        name: "Pesticide Spraying Machine",
        rate: 700,
        image: "assets/f-3.jpg",
        region: "Saravanampatti",
        link: "machine-details.html",
      },
      {
        name: "Drone Type Spraying",
        rate: 1000,
        image: "assets/f-4.webp",
        region: "Kanur",
        link: "machine-details.html",
      },
    ],
  },
];

//selecting the card container for each machine
const container = document.getElementById("equipmentContainer");

//Region Selection
const regionSelect = document.getElementById("regionSelect");

regionSelect.addEventListener("change", () => {
  const selectedRegion = regionSelect.value;
  renderEquipments(selectedRegion);
});

function renderEquipments(region = "Coimbatore") {
  container.innerHTML = "";

  equipmentData.forEach((section) => {
    const filteredMachines = section.machines.filter((machine) => {
      return region === "Coimbatore" || machine.region === region;
    });

    if (filteredMachines.length > 0) {
      const sectionDiv = document.createElement("div");
      sectionDiv.innerHTML = `
    <h2 class="text-2xl font-bold mb-4">${section.category}</h2>
    <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-6">
      ${filteredMachines
        .map(
          (machine) => `
        <div class="bg-white p-4 rounded shadow-md">
          <img src="${
            machine.image
          }" class="w-full h-48 object-cover mb-3 rounded" alt="${
            machine.name
          }" />
          <h3 class="text-lg font-semibold mb-1">${machine.name}</h3>
          <p class="text-green-600 font-semibold mb-3">₹${machine.rate}/hr</p>
          <button onclick='viewDetails(${JSON.stringify(
            machine
          )})' class="bg-gradient-to-r from-green-400 to-blue-500 hover:from-green-500 hover:to-blue-600 text-white font-bold py-2 px-4 rounded">
            View Details
          </button>
        </div>
      `
        )
        .join("")}
    </div>
  `;
      container.appendChild(sectionDiv);
    }
  });
}

function viewDetails(machine) {
  localStorage.setItem("selectedMachine", JSON.stringify(machine));
  window.location.href = "machine-deatils.html";
}

renderEquipments("Coimbatore");
