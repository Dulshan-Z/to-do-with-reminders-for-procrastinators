const express = require("express");
const router = express.Router();
const Task = require("../models/Task");

// GET all tasks
router.get("/", async (req, res) => {
  const tasks = await Task.find();
  res.json(tasks);
});

// ADD new task
router.post("/", async (req, res) => {
  const task = new Task(req.body);
  await task.save();
  res.json(task);
});

// UPDATE task
router.put("/:id", async (req, res) => {
  await Task.findByIdAndUpdate(req.params.id, req.body);
  res.json({ success: true });
});

// DELETE task
router.delete("/:id", async (req, res) => {
  await Task.findByIdAndDelete(req.params.id);
  res.json({ success: true });
});

module.exports = router;
