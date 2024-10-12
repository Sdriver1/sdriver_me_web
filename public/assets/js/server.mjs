import express from "express";
import { fileURLToPath } from "url";
import { dirname, join } from "path";
import fs from "fs";

// Helper to get the file path
const __filename = fileURLToPath(import.meta.url);
const __dirname = dirname(__filename);

// ======================== SERVER 1 (sdriver1.me - Port 8084) ========================

const app1 = express();
const port1 = 8084;

// Serve static files (JS, CSS, images)
app1.use("/assets", express.static(join(__dirname, "../../../public/assets")));

// Route for serving HTML for sdriver1.me (normal/index.html)
app1.get("/", (req, res) => {
  res.sendFile(join(__dirname, "../../../public/normal/index.html")); // Corrected path
});

// Listen on port 8084
app1.listen(port1, () => {
  console.log(`Server running on http://sdriver1.me:${port1}`);
});

// ======================== SERVER 2 (apcsa.sdriver1.me - Port 8085) ========================

const app2 = express();
const port2 = 8085;

// Serve static files (JS, CSS, images)
app2.use("/assets", express.static(join(__dirname, "../../../public/assets")));

// Route for serving HTML for apcsa.sdriver1.me (apcsa/index.html)
app2.get("/chatbot1", (req, res) => {
  res.sendFile(join(__dirname, "../../../public/apcsa/chatbot1.html")); // Corrected path
});
app2.get("/chatbot2", (req, res) => {
  res.sendFile(join(__dirname, "../../../public/apcsa/chatbot2.html")); // Corrected path
});

// Listen on port 8085
app2.listen(port2, () => {
  console.log(`Server running on http://apcsa.sdriver1.me:${port2}`);
});
// ======================== SERVER 3 (images.sdriver1.me - Port 8086) ========================

const app3 = express();
const port3 = 8086;

// Serve static files for apcsa.sdriver1.me
app3.use("/assets", express.static(join(__dirname, "../../../public/assets")));

// Route for serving images
app3.get("/:imageName", (req, res) => {
  const imageName = req.params.imageName;
  const imagePath = join(__dirname, "../../../public/assets/images", imageName);

  console.log(`Requested image: ${imageName}`);
  console.log(`Looking for image at: ${imagePath}`);

  // Check if the file exists before sending
  fs.access(imagePath, fs.constants.F_OK, (err) => {
    if (err) {
      console.error(`Image not found: ${imagePath}`);
      res.status(404).send("Image not found");
    } else {
      res.sendFile(imagePath);
    }
  });
});

// Listen on port 8086
app3.listen(port3, () => {
  console.log(`Server running on http://images.sdriver1.me:${port3}`);
});
