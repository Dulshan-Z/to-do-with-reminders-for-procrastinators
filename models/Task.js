const mongoose = require("mongoose");

const TaskSchema = new mongoose.Schema({
  title: { type: String, required: true },
  description: { type: String },
  dueDate: { type: String },
  priority: { type: String, default: "Low" },
  reminder: { type: String },
});

module.exports = mongoose.model("Task", TaskSchema);
