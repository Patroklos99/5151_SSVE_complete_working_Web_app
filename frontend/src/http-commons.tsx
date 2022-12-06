import axios from "axios";

/**
 * This is the configuration file for axios
 * modify it at your own risk
 */
export default axios.create({
  baseURL: "http://adve.info.uqam.ca/api",
  headers: {
    "Content-Type": "application/json"
  }
});