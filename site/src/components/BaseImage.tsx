import Image, { ImageProps } from 'next/image'

export default function BaseImage(props: ImageProps) {
    const basePath = process.env.NEXT_BASE_PATH || '';
    return <Image {...props} src={basePath + props.src} />
}
