import axios from "axios";

/**
 * This is the configuration file for axios
 * modify it at your own risk
 */
export default axios.create({
  baseURL: String(process.env.REACT_APP_BASE_URL),
  headers: {
    "Content-Type": "application/json"
  }
});