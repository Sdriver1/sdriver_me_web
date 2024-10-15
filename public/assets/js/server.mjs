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

app1.use("/assets", express.static(join(__dirname, "../../../public/assets")));

app1.get("/", (req, res) => {
  res.sendFile(join(__dirname, "../../../public/normal/index.html")); 
});
app1.get("/github", (req, res) => {
  res.sendFile(join(__dirname, "../../../public/normal/github.html")); 
});
app1.get("/linkedin", (req, res) => {
  res.sendFile(join(__dirname, "../../../public/normal/linkedin.html"));
});

app1.listen(port1, () => {
  console.log(`Server running on http://sdriver1.me:${port1}`);
});

// ======================== SERVER 2 (apcsa.sdriver1.me - Port 8085) ========================

const app2 = express();
const port2 = 8085;

app2.use("/assets", express.static(join(__dirname, "../../../public/assets")));

app2.get("/chatbot1", (req, res) => {
  res.sendFile(join(__dirname, "../../../public/apcsa/chatbot1.html")); 
});
app2.get("/chatbot2", (req, res) => {
  res.sendFile(join(__dirname, "../../../public/apcsa/chatbot2.html")); 
});

app2.listen(port2, () => {
  console.log(`Server running on http://apcsa.sdriver1.me:${port2}`);
});
// ======================== SERVER 3 (images.sdriver1.me - Port 8086) ========================

const app3 = express();
const port3 = 8086;

app3.use("/assets", express.static(join(__dirname, "../../../public/assets")));
app3.get("/:imageName", (req, res) => {
  const imageName = req.params.imageName;
  const imagePath = join(__dirname, "../../../public/assets/images", imageName);

  console.log(`Requested image: ${imageName}`);
  console.log(`Looking for image at: ${imagePath}`);

  fs.access(imagePath, fs.constants.F_OK, (err) => {
    if (err) {
      console.error(`Image not found: ${imagePath}`);
      res.status(404).send("Image not found");
    } else {
      res.sendFile(imagePath);
    }
  });
});

app3.listen(port3, () => {
  console.log(`Server running on http://images.sdriver1.me:${port3}`);
});
