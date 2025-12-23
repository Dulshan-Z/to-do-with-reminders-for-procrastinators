const express = require("express");
const cors = require("cors");
const connectDB = require("./db");

const app = express();

// Connect DB
connectDB();  // No top-level await needed

// Middleware
app.use(cors());
app.use(express.json());

// Routes
app.use("/tasks", require("./routes/tasks"));

// Test route
app.get("/", (req, res) => res.send("ProcrastinatorsTodo API running"));

// Start server
const PORT = 3000;
app.listen(PORT, () => console.log(`Server running on port ${PORT}`));
