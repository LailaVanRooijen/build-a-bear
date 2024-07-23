import { useState } from "react";
import { MdExpandCircleDown } from "react-icons/md";
import Checkbox from "./Checkbox";

const Filter = ({ title, items, label, addFilter }) => {
  const [showFilters, setShowFilters] = useState(true);
  return (
    <div>
      <div className="border-b-2 p-2 flex flex-row items-center justify-between">
        {`Filter by ${title}`}{" "}
        <MdExpandCircleDown
          onClick={() => setShowFilters(!showFilters)}
          className={`text-maize cursor-pointer text-xl hover:text-dark-maize transform ${
            showFilters ? "rotate-180" : ""
          }`}
        />
      </div>
      {items && showFilters && (
        <ul className={showFilters ? "" : "hidden"}>
          {items.map((item) => (
            <li key={item.id}>
              <Checkbox
                label={label}
                content={item.value}
                customCheckmark="🐻"
                handleChange={(label, target, isChecked) => {
                  addFilter(label, target, isChecked);
                }}
              />
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};

export default Filter;
