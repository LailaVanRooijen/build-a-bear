const CardRow: React.FC<CardRowProps> = ({ label, content, style }) => {
  return (
    <div className={`${style} w-full grid grid-cols-6 py-1`}>
      <p className="capitalize col-span-2 font-bold">{label}</p>
      <p className="col-span-4">{content}</p>
    </div>
  );
};

export default CardRow;

interface CardRowProps {
  label: string;
  content: string;
  style?: string;
}
