const equipmentData = [
  {
    category: "Planting and seeding",
    machines: [
      {
        name: "Seed Drill",
        rate: 2000,
        image: "assets/hm-1.jpeg",
        region: "Saravanampatti",
        link: "machine-details.html",
        description: "A seed drill is a crucial piece of planting and seeding equipment used to sow seeds at the correct depth and spacing across a field."
      },
      {
        name: "Peanut/Corn Seeding Machine.",
        rate: 2500,
        image: "assets/hm-2.jpg",
        region: "Saravanampatti",
        link: "machine-details.html",
        description: "A specialized seeder designed for planting soya bean seeds with precision. Ensures optimal spacing and depth for healthy growth and maximum yield of soya crops."
      },
      {
        name: "Manual Seeder.",
        rate: 1800,
        image: "assets/hm-3.jpg",
        region: "Singanallur",
        link: "machine-details.html",
        description: "A hand-operated seeder ideal for small-scale farming or precision planting in gardens and smaller fields."
      },
      {
        name: "Harveste Machine",
        rate: 2000,
        image: "assets/hm-4.jpg",
        region: "Kanur",
        link: "machine-details.html",
        description: "A versatile harvesting machine designed to efficiently gather mature crops from the field."
      },
    ],
  },
  {
    category: "Soil preparation",
    machines: [
      {
        name: "Mahindra Yuvaraj Tractor",
        rate: 500,
        image: "assets/t-1.webp",
        region: "Saravanampatti",
        link: "machine-details.html",
        description: "A compact and powerful tractor ideal for various soil preparation tasks in small to medium-sized farms."
      },
      {
        name: "3-Point Blade Offset Disc Harrow",
        rate: 500,
        image: "assets/t-2.jpg",
        region: "Singanallur",
        link: "machine-details.html",
        description: "A robust harrow with offset discs designed for primary and secondary tillage. Effectively breaks up clods, levels the soil, and prepares a suitable seedbed for planting."
      },
      {
        name: "Cultivator Machine",
        rate: 800,
        image: "assets/t-3.jpg",
        region: "Kanur",
        link: "machine-details.html",
        description: "A versatile machine used for secondary tillage operations such as loosening the soil, removing weeds, and preparing the seedbed after plowing. "
      },
      {
        name: "Harrow Machine",
        rate: 1000,
        image: "assets/t-4.webp",
        region: "Singanallur",
        link: "machine-details.html",
        description: "A tillage implement used to smooth and refine the soil after plowing or cultivation. Helps in breaking up remaining clods, leveling the surface."
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
        description: "A portable and efficient spraying machine powered by a battery, used for applying fertilizers, pesticides, and herbicides."
      },
      {
        name: "Pressure Spray Pump",
        rate: 400,
        image: "assets/f-2.webp",
        region: "Kanur",
        link: "machine-details.html",
        description: "A manually operated spray pump that uses pressure to apply liquids such as fertilizers and pesticides."
      },
      {
        name: "Pesticide Spraying Machine",
        rate: 700,
        image: "assets/f-3.jpg",
        region: "Saravanampatti",
        link: "machine-details.html",
        description: "A specialized spraying machine designed for the effective and even distribution of pesticides to protect crops from pests and diseases."
      },
      {
        name: "Drone Type Spraying",
        rate: 1000,
        image: "assets/f-4.webp",
        region: "Kanur",
        link: "machine-details.html",
        description: "An advanced aerial spraying system using drones to precisely apply fertilizers and pesticides over large agricultural fields."
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
    <div class="grid grid-cols-2 lg:grid-cols-4 gap-6">
      ${filteredMachines
        .map(
          (machine) => `
        <div class="bg-white p-4 rounded shadow-md">
          <img src="${
            machine.image
          }" class="w-full h-48 object-contain mb-3 rounded" alt="${
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

