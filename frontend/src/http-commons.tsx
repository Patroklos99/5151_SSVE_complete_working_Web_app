import axios from "axios";
import process from "process";

/**
 * This is the configuration file for axios
 * modify it at your own risk
 */

let development = process.env.NODE_ENV !== 'production'

export default axios.create({
  baseURL: String(process.env.REACT_APP_BASE_URL),
  headers: {
    "Content-Type": "application/json"
  }
});