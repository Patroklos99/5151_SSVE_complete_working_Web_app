import axios from "axios";
import process from "process";

/**
 * This is the configuration file for axios
 * modify it at your own risk
 */
export default axios.create({
  /**
  baseURL: String(process.env.NODE_ENV) == "production"
    ? process.env.REACT_APP_BASE_URL
    : process.env.DEV_REACT_APP_BASE_URL,
  */
  baseURL: "http://adve.info.uqam.ca/api",
  headers: {
    "Content-Type": "application/json"
  }
});