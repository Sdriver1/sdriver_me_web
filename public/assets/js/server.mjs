import express from "express";
import { fileURLToPath } from "url";
import { dirname, join } from "path";
import path from "path";
import fs from "fs";

const __filename = fileURLToPath(import.meta.url);
const __dirname = dirname(__filename);
const port = 8084;
const app = express();

const serveStatic = (route, directory) => {
  app.use(route, express.static(join(__dirname, directory), { index: false }));
};
serveStatic("/assets/css", "../../assets/css");
serveStatic("/assets/js", "../../assets/js");
serveStatic("/assets/images", "../../assets/images");
serveStatic("/assets/fonts", "../../assets/fonts");
serveStatic("/assets/bootstrap", "../../assets/bootstrap");

const serveHTML = (route, file) => {
  app.get(route, (req, res) => res.sendFile(join(__dirname, file)));
};

const htmlRoutes = [
  { route: "/webpage/", file: "../../index.html" },
  { route: "/", file: "../../404.html" },
];

htmlRoutes.forEach((route) => serveHTML(route.route, route.file));

app.get("/images/:imageName", (req, res) => {
  const imageName = req.params.imageName;
  const imagePath = join(__dirname, "../../assets/images", imageName);

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

app.listen(port, () => {
  console.log(`Server running at https://45.131.65.230:8084`);
});
