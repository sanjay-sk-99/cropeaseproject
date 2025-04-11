
const equipmentData = [
  {
    category: 'Harvest Machines',
    machines: [
      {
        name: 'Rice Harvester',
        rate: 5000,
        image: 'assets/hm-1.jpg',
        link: 'machine-details.html'
      },
      {
        name: 'Multifunctional Harvester',
        rate: 7000,
        image: 'assets/hm-2.jpg',
        link: 'machine-details.html'
      },
      {
        name: 'Small Rice Combine Harvester',
        rate: 6000,
        image: 'assets/hm-3.jpg',
        link: 'machine-details.html'
      },
      {
        name: 'Soyabean Combine Harvester',
        rate: 9000,
        image: 'assets/hm-4.webp',
        link: 'machine-details.html'
      }
    ]
  },
  {
    category: 'Tractors',
    machines: [
      {
        name: 'Mahindra Yuvaraj Tractor',
        rate: 3000,
        image: 'assets/t-1.webp',
        link: 'machine-details.html'
      },
      {
        name: 'Mahindra OJA',
        rate: 7000,
        image: 'assets/t-2.webp',
        link: 'machine-details.html'
      },
      {
        name: 'Swaraj Tractor',
        rate: 2000,
        image: 'assets/t-3.jpg',
        link: 'machine-details.html'
      },
      {
        name: '50hp John Deere Tractor',
        rate: 4000,
        image: 'assets/t-4.webp',
        link: 'machine-details.html'
      }
    ]
  },
  {
    category: 'Fertilizers & Pesticides',
    machines: [
      {
        name: 'Battery Spraying Machine',
        rate: 500,
        image: 'assets/f-1.webp',
        link: 'machine-details.html'
      },
      {
        name: 'Pressure Spray Pump',
        rate: 1000,
        image: 'assets/f-2.webp',
        link: 'machine-details.html'
      },
      {
        name: 'Pesticide Spraying Machine',
        rate: 2000,
        image: 'assets/f-3.jpg',
        link: 'machine-details.html'
      },
      {
        name: 'Drone Type Spraying',
        rate: 3000,
        image: 'assets/f-4.webp',
        link: 'machine-details.html'
      }
    ]
  }
]

//selecting the card container for each machine
const container = document.getElementById('equipmentContainer')

equipmentData.forEach(section => {
  const sectionDiv = document.createElement('div')
  sectionDiv.innerHTML = `
    <h2 class="text-2xl font-bold mb-4">${section.category}</h2>
    <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-6">
      ${section.machines
        .map(
          machine => `
        <div class="bg-white p-4 rounded shadow-md">
          <img src="${
            machine.image
          }" class="w-full h-48 object-cover mb-3 rounded" alt="${
            machine.name
          }" />
          <h3 class="text-lg font-semibold mb-1">${machine.name}</h3>
          <p class="text-green-600 font-semibold mb-3">₹${
            machine.rate
          }/hr</p>
          <button onclick='viewDetails(${JSON.stringify(
            machine
          )})' class="bg-gradient-to-r from-green-400 to-blue-500 hover:from-green-500 hover:to-blue-600 text-white font-bold py-2 px-4 rounded">
            View Details
          </button>
        </div>
      `
        )
        .join('')}
    </div>
  `
  container.appendChild(sectionDiv)
})


function viewDetails(machine) {
  localStorage.setItem('selectedMachine', JSON.stringify(machine))
  window.location.href = "machine-deatils.html";
}
