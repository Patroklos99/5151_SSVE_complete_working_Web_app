import axios from "axios";

/**
 * This is the configuration file for axios
 * modify it at your own risk
 */
export default axios.create({
  baseURL: "http://localhost:8080",
  headers: {
    "Content-Type": "application/json"
  }
});